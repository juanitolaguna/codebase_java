package mandelbrot_hm;

import javafx.concurrent.Task;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import java.util.stream.IntStream;

/**
 * Created on 12.06.17.
 */
public class MandelbrotSetTask extends Task {

    private final boolean parallel, antialiased;
    private final PixelWriter pixelWriter;
    private final int width, height;
    private final double minX, minY, maxX, maxY;
    private final double minR, minI, maxR, maxI;


    public MandelbrotSetTask(boolean parallel, PixelWriter pixelWriter, int width, int height, double minR, double minI,
                             double maxR, double maxI, double minX, double minY, double maxX, double maxY, boolean fast) {

        this.parallel = parallel;
        this.pixelWriter = pixelWriter;
        this.width = width;
        this.height = height;
        this.maxX = maxX;
        this.minX = minX;
        this.maxY = maxY;
        this.minY = minY;
        this.minR = minR;
        this.maxR = maxR;
        this.minI = minI;
        this.maxI = maxI;
        this.antialiased = !fast;

    }


    //TODO


    @Override
    protected Long call() throws Exception {
        synchronized (pixelWriter) {
            //Prepare Image
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    pixelWriter.setColor(x, y, Color.TRANSPARENT);
                }
            }
        }

        IntStream yStream = IntStream.range(0, height);

        if (parallel) {
            yStream = yStream.parallel();
        } else {
            yStream = yStream.sequential();
        }

//        yStream.forEach((int y) -> {
//            for (int x = 0; x < width; x++) {
//
//                //skip excludet Rectangular area
//                if (x >= maxX || x < minX || y >= maxY || y < minY) {
//                    continue;
//                }
//
//                Color c = calcPixel(x, y);
//
//                synchronized (pixelWriter) {
//                    pixelWriter.setColor(x,y,c);
//                }
//            }
//        });

        return null;
    }


}
