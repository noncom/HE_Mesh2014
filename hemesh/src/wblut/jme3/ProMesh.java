package wblut.jme3;

import java.nio.FloatBuffer;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer.Type;
import com.jme3.util.BufferUtils;

public class ProMesh {
    
    int nv;
    
    Mesh.Mode mode;
    
    FloatBuffer vertices;
    FloatBuffer normals;
    FloatBuffer uvs;
//    IntBuffer indices;

    public ProMesh(final int nv, final Mesh.Mode mode) {
	this.nv = nv;
	this.mode = mode;
	initBuffers();
    }

    public void initBuffers() {
	vertices = BufferUtils.createFloatBuffer(nv * 3);
	normals = BufferUtils.createFloatBuffer(nv * 3);
	uvs = BufferUtils.createFloatBuffer(nv * 2);
//	indices = BufferUtils.createIntBuffer(nv * 2);
    }

    public Mesh mesh() {
	final Mesh mesh = new Mesh();
	
	System.out.println("v pos1 =" + vertices.position() + " pos2 =" + normals.position());
	
	vertices.flip();
	normals.flip();
	uvs.flip();
//	indices.rewind();
	
	System.out.println("v cap =" + vertices.capacity() + " lim =" + vertices.limit());
	
	final FloatBuffer resVectices = BufferUtils.createFloatBuffer(vertices.limit());
	final FloatBuffer resNormals = BufferUtils.createFloatBuffer(normals.limit());
	final FloatBuffer resUvs = BufferUtils.createFloatBuffer(uvs.limit());
//	final IntBuffer resIndices = BufferUtils.createIntBuffer(indices.limit());
	
	System.out.println("A[]");
	
	mesh.setBuffer(Type.Position, 3, resVectices.put(vertices));
	System.out.println("B[]");
//	if(normals.capacity() > 0) mesh.setBuffer(Type.Normal, 3, resNormals.put(normals));
	System.out.println("C[]");
	mesh.setBuffer(Type.TexCoord, 2, resUvs.put(uvs));
	System.out.println("D[]");
//	String o = "";
//	for(int i = 0; i < vertices.capacity(); i++) {
//	    o += ", " + vertices.get();
//	}
//	vertices.rewind();
//	System.out.println("vertices = " + o);
	
//	mesh.setBuffer(Type.Index, 3, resIndices.put(indices));
	mesh.setMode(mode);
	return mesh;
    }
    
    public void addVertex(float x, float y, float z) {
	vertices.put(x);
	vertices.put(y);
	vertices.put(z);
    }
    
    public void addNormal(float x, float y, float z) {
	normals.put(x);
	normals.put(y);
	normals.put(z);
    }
    
    public void addUv(float u, float v) {
	uvs.put(u);
	uvs.put(v);
    }
}
