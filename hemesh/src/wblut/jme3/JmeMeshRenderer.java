package wblut.jme3;

import java.util.Stack;
import processing.core.PImage;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Transform;

public class JmeMeshRenderer {
    
    Stack<Transform> matrices;
    
    Transform matrix;
    Transform newMatrix;
    
    ProMesh faces;
    ProMesh edges;
    ProMesh poly;
    ProMesh segment;
    ProMesh points;

    ColorRGBA fill, stroke;
    
    Stack<ColorRGBA> styles;
    
    public JmeMeshRenderer() {
	matrices = new Stack<Transform>();
	styles = new Stack<ColorRGBA>();
	fill = new ColorRGBA();
	stroke = new ColorRGBA();
    }
    
    public void point(final float x, final float y, final float z) {
    }

    public void pushMatrix() {
	newMatrix = matrix.clone();
	matrices.push(matrix);
	matrix = newMatrix;
	newMatrix = null;
    }

    public void popMatrix() {
	newMatrix = matrices.pop();
	matrix = newMatrix.clone();
	newMatrix = null;
    }

    public void translate(final float x, final float y, final float z) {
	matrix.setTranslation(x, y, z);
    }

    public void box(final float r) {
    }

    public void box(final float width, final float height, final float depth) {
	// TODO Auto-generated method stub
    }

    // 2d line
    public void line(float x, float y, float x2, float y2) {
	//points.a
    }

    public void line(float x, float y, float z, float xx, float yy, float zz) {

    }

    public void rotate(final float x, final float y, final float z) {
	matrix.setRotation(matrix.getRotation().mult(
		new Quaternion().fromAngles(x, y, z)));
    }

    public void ellipse(final int i, final int j, final float f, final float g) {
	// TODO Auto-generated method stub
    }

    public void beginShape() {
	// TODO Auto-generated method stub
    }

    public void beginShape(final int polygon) {
	// TODO Auto-generated method stub
    }

    public void endShape() {
	// TODO Auto-generated method stub
    }

    public void endShape(final int close) {
	// TODO Auto-generated method stub
    }

    public void texture(final PImage texture) {
	// TODO Auto-generated method stub
    }

    public void vertex(final float f, final float g, final float h) {
	// TODO Auto-generated method stub
    }

    public void vertex(float x, float y, float z, float u, float v) {
	// TODO Auto-generated method stub
    }

    public void normal(float x, float y, float z) {
	// TODO Auto-generated method stub
    }

    public void fill(final int color) {
	fill.set(color, color, color, 1);
    }

    public void fill(final int r, final int g, final int b) {
	fill.set(r, g, b, 1);
    }

    public void popStyle() {
	styles.push(fill.clone());
	styles.push(stroke.clone());
    }

    public void pushStyle() {
	stroke = styles.pop();
	fill = styles.pop();
    }

    public void vertex(final float xf, final float yf) {
	// TODO Auto-generated method stub
    }

    public double screenX(final float xf, final float yf, final float zf) {
	// TODO Auto-generated method stub
	return 0;
    }

    public double screenY(final float xf, final float yf, final float zf) {
	// TODO Auto-generated method stub
	return 0;
    }

    public void stroke(int r, int g, int b) {
	stroke.set(r, g, b, 1);
    }

    public int getHeight() {
	// TODO Auto-generated method stub
	return 0;
    }

    public void bezierVertex(final float xf, final float yf, final float zf,
	    final float xf2, final float yf2, final float zf2, final float xf3,
	    final float yf3, final float zf3) {
	// TODO Auto-generated method stub
    }
}
