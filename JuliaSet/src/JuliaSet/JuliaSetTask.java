package JuliaSet;

import javafx.concurrent.Task;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

import java.util.stream.IntStream;

/**
 * Created on 22.06.17 - Pawel Snatenkov
 */
public class JuliaSetTask extends Task {

    private static final double CAL_MAX_COUNT = 1000;
    private static final double LENGTH_BOUNDARY = 6d;
    private final PixelWriter pixelWriter;
    private final int width, height;
    private final double minX = 0, minY = 0, maxX = 0, maxY = 0;
    private final double minR, minI, maxR, maxI;
    private Complex constant;
    private volatile boolean hasUpdates;

    public JuliaSetTask(PixelWriter pixelWriter, int width, int height, double minR,
                        double minI, double maxR, double maxI, Complex constant) {
        this.pixelWriter = pixelWriter;
        this.width = width;
        this.height = height;
        this.minR = minR;
        this.maxR = maxR;
        this.minI = minI;
        this.maxI = maxI;
        this.constant = constant;
    }

    @Override
    protected Object call() throws Exception {
        synchronized (pixelWriter) {
            // Prepares an image
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    pixelWriter.setColor(x, y, Color.TRANSPARENT);
                }
            }
        }

        IntStream yStream = IntStream.range(0, height);
        yStream.parallel();

        yStream.forEach((int y) -> {

            // Do pixels in horizontal lines always sequentially
            for (int x = 0; x < width; x++) {

                // Skip excluded rectangular area
                if (!(x >= maxX || x < minX || y >= maxY || y < minY)) {
                    continue;
                }
                Color c = calcPixel(x, y);

                if (isCancelled()) {
                    return;
                }
                synchronized (pixelWriter) {
                    pixelWriter.setColor(x, y, c);
                }
                hasUpdates = true;
            }
        });
        return null;
    }

    private Color calcPixel(double x, double y) {
        double re = (minR * (width - x) + x * maxR) / width;
        double im = (minI * (height - y) + y * maxI) / height;
        Complex calPixel = new Complex(re, im);
        return getColor(calc(calPixel, constant));
    }

    private static int calc(Complex comp, Complex constant) {
        int count = 0;
        do {
            comp.times(comp).plus(constant);
            count++;
        } while (count < CAL_MAX_COUNT && comp.lengthSQ() < LENGTH_BOUNDARY);
        return count;
    }


    private static Color getColor(int count) {
        if (count >= colors.length) {
            return Color.BLACK;
        }
        return colors[count];
    }

    static final Color[] colors = new Color[1000];

    static {
        Color[] cc = {
                Color.rgb(10, 0, 0),
                Color.RED,
                Color.WHITE,
                Color.RED,
                Color.rgb(100, 0, 0),
                Color.RED,
                Color.rgb(50, 0, 0)
        };

        /**
         * Color stops for colors table: relative position in the table
         */
        double[] cp = {
                0, 0.17, 0.25, 0.30, 0.5, 0.75, 1,};

        /**
         * Color table population
         */
        int j = 0;
        for (int i = 0; i < colors.length; i++) {
            double p = (double) i / (colors.length - 1);
            if (p > cp[j + 1]) {
                j++;
            }

            double val = (p - cp[j]) / (cp[j + 1] - cp[j]);
            colors[i] = cc[j].interpolate(cc[j + 1], val);
        }
    }

    public boolean hasUpdates() {
        return hasUpdates;
    }

    public void clearHasUpdates() {
        hasUpdates = false;
    }

}
