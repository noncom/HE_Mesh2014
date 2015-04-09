package wblut.jme3;

import java.util.Stack;
import processing.core.PImage;
import com.jme3.app.Application;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Transform;
import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh.Mode;

public class JmeMeshRenderer {
    
    Stack<Transform> matrices;
    
    Transform matrix;
    Transform newMatrix;
    
    public ProMesh faces;
    public ProMesh edges;
    public ProMesh polyline;
    public ProMesh segment;
    public ProMesh points;

    ColorRGBA fill, stroke;
    
    Stack<ColorRGBA> styles;
    
    Application app;
    
    public JmeMeshRenderer(Application app) {
	this.app = app;
	
	matrices = new Stack<Transform>();
	styles = new Stack<ColorRGBA>();
	fill = new ColorRGBA();
	stroke = new ColorRGBA();
    }
    
    public void initBuffers(int count) {
	System.out.println("WB_RendererJME: init to count " + count);
	count = (count / 2) * 3; // <<<< WHY this is the exact number of required floats?
	faces = new ProMesh(count, Mode.Triangles);
	edges = new ProMesh(count, Mode.LineLoop);
	polyline = new ProMesh(count, Mode.Lines);
	segment = new ProMesh(count, Mode.Lines);
	points = new ProMesh(count, Mode.LineLoop);
    }
    
    public void point(float x, float y, float z) {
	points.addVertex(x, y, z);
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
    public void line(float x1, float y1, float x2, float y2) {
	points.addVertex(x1, y1, 0);
	points.addVertex(x2, y2, 0);
    }

    public void line(float x1, float y1, float z1, float x2, float y2, float z2) {
	points.addVertex(x1, y1, z1);
	points.addVertex(x2, y2, z2);
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

    public void vertex(float x, float y, float z) {
	points.addVertex(x, y, z);
    }

    public void vertex(float x, float y, float z, float u, float v) {
	points.addVertex(x, y, z);
	points.addUv(u, v);
    }

    public void normal(float x, float y, float z) {
	points.addNormal(x, y, z);
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

    public void vertex(float x, float y) {
	points.addVertex(x, y, 0);
    }

    public double screenX(float x, float y, float z) {
	return app.getCamera().getScreenCoordinates(new Vector3f(x, y, z)).x;
    }

    public double screenY(float x, float y, float z) {
	return app.getCamera().getScreenCoordinates(new Vector3f(x, y, z)).y;
    }

    public void stroke(int r, int g, int b) {
	stroke.set(r, g, b, 1);
    }

    public int getHeight() {
	return app.getCamera().getHeight();
    }

    public void bezierVertex(final float xf, final float yf, final float zf,
	    final float xf2, final float yf2, final float zf2, final float xf3,
	    final float yf3, final float zf3) {
	// TODO Auto-generated method stub
    }
}
