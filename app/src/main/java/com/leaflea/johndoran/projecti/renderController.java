package com.leaflea.johndoran.projecti;

import android.content.Context;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by John Doran on 02/08/2015.
 */


public class renderController {



    public renderController() {
        // TODO Auto-generated constructor stub
    }
    private static FloatBuffer mVertexBuffer = null;
    private static ShortBuffer mTriangleBorderIndicesBuffer = null;
    private static int mNumOfTriangleBorderIndices = 0;
    private Context mContext;

    public void giveContext(Context mContext){
        this.mContext=mContext;

    }

    public FloatBuffer vertexBufferGenerator(float[] verts){
        FloatBuffer vertices;
        ByteBuffer vbb = ByteBuffer.allocateDirect(verts.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertices = vbb.asFloatBuffer();
        vertices.put(verts);
        vertices.position(0);
        return vertices;
    }
    public FloatBuffer colorsBufferGenerator(float[] colors){
        FloatBuffer c;
        ByteBuffer vbb = ByteBuffer.allocateDirect(colors.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        c = vbb.asFloatBuffer();
        c.put(colors);
        c.position(0);
        return c;
    }

    public FloatBuffer uvBufferGenerator(float[] uvc){
        FloatBuffer c;
        ByteBuffer vbb = ByteBuffer.allocateDirect(uvc.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        c = vbb.asFloatBuffer();
        c.put(uvc);
        c.position(0);
        return c;
    }
    public ShortBuffer indexBufferGenerator(short[] index){
        ShortBuffer c;
        ByteBuffer vbb = ByteBuffer.allocateDirect(index.length * 2);
        vbb.order(ByteOrder.nativeOrder());
        c = vbb.asShortBuffer();
        c.put(index);
        c.position(0);
        return c;
    }

    public void drawWithBuffers(GL10 gl,FloatBuffer mVertexBuffer,FloatBuffer mColorBuffer,FloatBuffer mTextureBuffer,ShortBuffer mIndexBuffer,int numberOfIndices, int textureName){
        gl.glEnable(GL10.GL_TEXTURE_2D);

        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

        //Point to the right vertex array
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        mVertexBuffer.position(0);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);


        //Point to the right color array
        gl.glDisable(GL10.GL_TEXTURE_2D);

        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        mColorBuffer.position(0);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, mColorBuffer);

        // gl.glEnable(GL10.GL_BLEND);
        // gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);


        //Get the texture coordinate buffer ready

        gl.glEnable(GL10.GL_TEXTURE_2D);

        MR.fjkf(textureName);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);


        mIndexBuffer.position(0);

        // Draw all lines
        gl.glDrawElements(GL10.GL_TRIANGLES, mIndexBuffer.capacity(), GL10.GL_UNSIGNED_SHORT, mIndexBuffer);


        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
    }

    public int[] mTextureList=null;
    public void drawWithBuffers(GL10 gl,FloatBuffer mVertexBuffer,FloatBuffer mTextureBuffer,ShortBuffer mIndexBuffer,int numberOfIndices, int textureName){

        gl.glEnable(GL10.GL_TEXTURE_2D);

        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

        //Point to the right vertex buffer
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        mVertexBuffer.position(0);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);

        //Get the texture coordinate buffer ready

        MR.fjkf(textureName);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);

        //Get the index buffer ready
        mIndexBuffer.position(0);

        //Draw
        gl.glDrawElements(GL10.GL_TRIANGLES, mIndexBuffer.capacity() , GL10.GL_UNSIGNED_SHORT, mIndexBuffer);

        //Cover your tracks
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
    }

    public void drawWithBuffers(GL10 gl,FloatBuffer mVertexBuffer,ShortBuffer mIndexBuffer,int numberOfIndices){


        gl.glDisable(GL10.GL_TEXTURE_2D);

        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

        //Point to the right vertex buffer
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        mVertexBuffer.position(0);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);

        //Get the index buffer ready
        mIndexBuffer.position(0);


        //Draw
        //gl.glDrawElements(GL10.GL_LINES, mIndexBuffer.capacity() , GL10.GL_UNSIGNED_SHORT, mIndexBuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, mIndexBuffer.capacity() , GL10.GL_UNSIGNED_SHORT, mIndexBuffer);


        //Cover your tracks
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
    }
    public void drawLineWithBuffers(GL10 gl,FloatBuffer mVertexBuffer,ShortBuffer mIndexBuffer,int numberOfIndices){


        gl.glDisable(GL10.GL_TEXTURE_2D);

        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

        //Point to the right vertex buffer
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        mVertexBuffer.position(0);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);

        //Get the index buffer ready
        mIndexBuffer.position(0);


        //Draw
        //gl.glDrawElements(GL10.GL_LINES, mIndexBuffer.capacity() , GL10.GL_UNSIGNED_SHORT, mIndexBuffer);
        gl.glDrawElements(GL10.GL_LINES, mIndexBuffer.capacity() , GL10.GL_UNSIGNED_SHORT, mIndexBuffer);


        //Cover your tracks
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
    }
    public void drawWithBuffers(GL10 gl,Boolean noTexture,FloatBuffer mVertexBuffer,FloatBuffer mColorBuffer,ShortBuffer mIndexBuffer,int numberOfIndices){

       // gl.glEnable(GL10.GL_BLEND);
        //gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
        //gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA);

        //gl.glDisable(GL10.GL_BLEND);

        gl.glDisable(GL10.GL_TEXTURE_2D);



        //Point to vertex buffer
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        mVertexBuffer.position(0);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);
        //Point to color buffer
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        mColorBuffer.position(0);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, mColorBuffer);

        //Get index buffer ready
        mIndexBuffer.position(0);

        //Draw
        //gl.glDrawElements(GL10.GL_LINES, mIndexBuffer.capacity(), GL10.GL_UNSIGNED_SHORT, mIndexBuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, mIndexBuffer.capacity(), GL10.GL_UNSIGNED_SHORT, mIndexBuffer);


        //Cover your tracks
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
    public static MyRenderer MR;
    public static void setMR(MyRenderer MR){
        renderController.MR=MR;
    }
    public static MyRenderer getMR(){
        return MR;
    }

}