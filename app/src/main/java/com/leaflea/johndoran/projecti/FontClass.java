package com.leaflea.johndoran.projecti;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;
//import android.R;
/**
 * Created by John on 15/07/15.
 */

public class FontClass {
    private GL10 gl;

    public FontClass(GL10 gl1) {
        this.MR=rC.getMR();
        this.gl=gl1;
    }

    static renderController rC=new renderController();
    static MyRenderer MR;
    FloatBuffer mSentenceVerts=null;
    FloatBuffer mSentenceUVCoords=null;
    ShortBuffer mSentenceIndices=null;

    //public int texture=R.drawable.textureatlas;

   // public int texture=R.drawable.goldface;


    public int texture;


    public void drawFont(float x,float y,float z,float w,float h,String sentences){
        texture=R.drawable.couriernewtextureatlastesttwo;

        this.MR=rC.getMR();

        char[] letters=new char[sentences.length()];
        for (int c=0; c<sentences.length();c++){
            letters[c]=sentences.charAt(c);
        }

        float widthOfEachChar=w/(float)sentences.length();


        //Precursor to vertices buffer
        float vertices[]=new float[sentences.length()*4*3];
        float UVCoords[]=new float[sentences.length()*4*2];
        float letterUVCoords[];
        for (int c=0;c<sentences.length();c++){

            letterUVCoords=getUVCoords(letters[c]);
            for (int i=0 ;i<8;i++) {
                UVCoords[c*8+i]=letterUVCoords[i];

            }

            vertices[c*4*3+0]=x+(float)c*widthOfEachChar      ;
            vertices[c*4*3+3]=x+(float)(c+1)*widthOfEachChar+   0.000001f ;
            vertices[c*4*3+6]=x+(float)(c+1)*widthOfEachChar+   0.000001f ;
            vertices[c*4*3+9]=x+(float)(c)*widthOfEachChar    ;

            vertices[c*4*3+1] =y+(float)h;
            vertices[c*4*3+4] =y+(float)h;
            vertices[c*4*3+7] =y;
            vertices[c*4*3+10]=y;

            vertices[c*4*3+2] =-z;
            vertices[c*4*3+5] =-z;
            vertices[c*4*3+8] =-z;
            vertices[c*4*3+11]=-z;

        }
        short[] indices=new short[sentences.length()*6];
        for (int d=0;d<sentences.length();d++){

            indices[d*6+0]=(short)(d*4+0);
            indices[d*6+1]=(short)(d*4+1);
            indices[d*6+2]=(short)(d*4+2);
            indices[d*6+3]=(short)(d*4+2);
            indices[d*6+4]=(short)(d*4+3);
            indices[d*6+5]=(short)(d*4+0);

        }

        mSentenceVerts     =rC.vertexBufferGenerator(vertices);
        mSentenceUVCoords  =rC.uvBufferGenerator(UVCoords);
        mSentenceIndices   =rC.indexBufferGenerator(indices);
        gl.glPushMatrix();
        gl.glRotatef(180f,0,1,0);
        rC.drawWithBuffers(gl,mSentenceVerts,mSentenceUVCoords,mSentenceIndices,indices.length,texture);
        gl.glPopMatrix();
    }

    public float UVGlyphWidth   =0.1f;
    public float UVGlyphHeight  =0.1f;

    public float[] getUVCoords2(char letter){
        float[] coords=new float[8];
        UVGlyphWidth   =0.09f;
        UVGlyphHeight  =0.094f;

        //UVGlyphWidth   =0.1f;
        //UVGlyphHeight  =0.1f;
        float x=0;
        float y=0;
         int let=Character.toString(letter).hashCode();
        //int let=Character.getNumericValue(letter);
        //  int t="a".hashCode();
        switch(let){
            case 32://space
                x=0.01f;
                y=0.01f;
                UVGlyphWidth   =0.01f;
                UVGlyphHeight  =0.01f;
                break;
            case 45://'.'
                UVGlyphWidth   =0.1f;
                UVGlyphHeight  =0.08f;
                x=0.3f;
                y=0.16f;
                break;
            case 46://'.'
                UVGlyphWidth   =0.1f;
                UVGlyphHeight  =-0.1f;
                x=0.4f;
                y=0.1f;
                break;
            case 48://0
                x=0.6f;
                y=0.1f;
                break;
            case 49:
                x=0.7f;
                y=0.1f;
                break;
            case 50:
                x=0.8f;
                y=0.1f;
                break;
            case 51:
                x=0.9f;
                y=0.1f;
                break;
            case 52:
                x=0.0f;
                y=0.2f;
                break;
            case 53:
                x=0.1f;
                y=0.2f;
                break;
            case 54:
                x=0.2f;
                y=0.2f;
                break;
            case 55:
                x=0.3f;
                y=0.2f;
                break;
            case 56:
                x=0.4f;
                y=0.2f;
                break;
            case 57:
                x=0.5f;
                y=0.2f;
                break;
            case 58:////colon
                x=0.6f;
                y=0.19f;

                UVGlyphWidth   =0.04f;
                UVGlyphHeight  =0.09f;

                break;
            case 65://A
                x=0.3f;
                y=0.3f;
                break;
            case 66:
                x=0.4f;
                y=0.3f;
                break;
            case 67:
                x=0.5f;
                y=0.3f;
                break;
            case 68:
                x=0.6f;
                y=0.3f;
                break;
            case 69:
                x=0.7f;
                y=0.3f;
                break;
            case 70:
                x=0.8f;
                y=0.3f;
                break;
            case 71:
                x=0.9f;
                y=0.3f;
                break;
            case 72:
                x=0.0f;
                y=0.4f;
                break;
            case 73:
                x=0.1f;
                y=0.4f;
                break;
            case 74:
                x=0.2f;
                y=0.4f;
                break;
            case 75:
                x=0.3f;
                y=0.4f;
                break;
            case 76:
                x=0.4f;
                y=0.4f;
                break;
            case 77:
                x=0.5f;
                y=0.4f;
                break;
            case 78:
                x=0.6f;
                y=0.4f;
                break;
            case 79:
                x=0.7f;
                y=0.4f;
                break;
            case 80:
                x=0.8f;
                y=0.4f;
                break;
            case 81:
                x=0.9f;
                y=0.5f;
                break;
            case 82:
                x=0.0f;
                y=0.5f;
                break;
            case 83:
                x=0.1f;
                y=0.5f;
                break;
            case 84:
                x=0.2f;
                y=0.5f;
                break;
            case 85:
                x=0.3f;
                y=0.5f;
                break;
            case 86:
                x=0.4f;
                y=0.5f;
                break;
            case 87:
                x=0.5f;
                y=0.5f;
                break;
            case 88:
                x=0.6f;
                y=0.5f;
                break;
            case 89:
                x=0.7f;
                y=0.5f;
                break;
            case 90:
                x=0.8f;
                y=0.5f;
                break;
            default:
                x=0.8f;
                y=0.5f;
                break;

        }

        float indentLeft=0.02f;
        coords[0]=x-indentLeft;
        coords[1]=y;
        coords[2]=x+UVGlyphWidth;
        coords[3]=y;
        coords[4]=x+UVGlyphWidth;
        coords[5]=y+UVGlyphHeight*0.8f;
        coords[6]=x-indentLeft;
        coords[7]=y+UVGlyphHeight*0.8f;


        return coords;
    }

    public float[] getUVCoords(char letter){
        float[] coords=new float[8];
        //texture=R.drawable.couriernewtextureatlastgame;
        texture=R.drawable.couriernewtextureatlastesttwo;


        UVGlyphWidth   =24f/256f;
        UVGlyphHeight  =37f/256f;

        //UVGlyphWidth   =0.1f;
        //UVGlyphHeight  =0.1f;
        float x=0;
        float y=0;
        int let=Character.toString(letter).hashCode();
        //int let=Character.getNumericValue(letter);
        //  int t="a".hashCode();
        switch(let){
            case 32://space
                x=10f;
                y=222f;
                //UVGlyphWidth   =0.001f;
                //UVGlyphHeight  =0.001f;
                break;
            case 33://!
                x=174f;
                y=126f;
                //UVGlyphWidth   =0.01f;
                //UVGlyphHeight  =0.01f;
                break;
            case 45://'-' dash line
                //UVGlyphWidth   =0.1f;
                //UVGlyphHeight  =0.08f;
                x=198f;
                y=126f;
                break;
            case 46://'.'full stop
                //UVGlyphWidth   =0.1f;
                //UVGlyphHeight  =-0.1f;
                x=150f;
                y=126f;
                break;
            case 44:////comma
                x=222f;
                y=126f;

                //UVGlyphWidth   =0.04f;
                //UVGlyphHeight  =0.09f;

                break;
            case 48://0
                x=150f;
                y=84f;
                break;
            case 49:
                x=174f;
                y=84f;
                break;
            case 50:
                x=198f;
                y=84f;
                break;
            case 51:
                x=222f;
                y=84f;
                break;
            case 52:
                x=6f;
                y=126f;
                break;
            case 53:
                x=30f;
                y=126f;
                break;
            case 54:
                x=54f;
                y=126f;
                break;
            case 55:
                x=78f;
                y=126f;
                break;
            case 56:
                x=102f;
                y=126f;
                break;
            case 57:
                x=126f;
                y=126f;
                break;
            case 58:////colon :
                x=0f;
                y=168f;

                //UVGlyphWidth   =0.04f;
                //UVGlyphHeight  =0.09f;

                break;
            case 65://A
                x=6f;
                y=0;
                break;
            case 66:
                x=30f;
                y=0f;
                break;
            case 67:
                x=54f;
                y=0f;
                break;
            case 68:
                x=78f;
                y=0f;
                break;
            case 69:
                x=102f;
                y=0f;
                break;
            case 70:
                x=126f;
                y=0f;
                break;
            case 71:
                x=150f;
                y=0f;
                break;
            case 72:
                x=174f;
                y=0f;
                break;
            case 73:
                x=198f;
                y=0;
                break;
            case 74:
                x=222f;
                y=0f;
                break;
            case 75:
                x=6f;
                y=42f;
                break;
            case 76:
                x=30f;
                y=42f;
                break;
            case 77:
                x=54f;
                y=42f;
                break;
            case 78:
                x=78f;
                y=42f;
                break;
            case 79:
                x=102f;
                y=42f;
                break;
            case 80:
                x=126f;
                y=42f;
                break;
            case 81:
                x=150f;
                y=42f;
                break;
            case 82:
                x=174f;
                y=42f;
                break;
            case 83:
                x=198f;
                y=42f;
                break;
            case 84:
                x=222f;
                y=42f;
                break;
            case 85:
                x=6f;
                y=84f;
                break;
            case 86:
                x=30f;
                y=84f;
                break;
            case 87:
                x=54f;
                y=84f;
                break;
            case 88:
                x=78f;
                y=84f;
                break;
            case 89:
                x=102f;
                y=84f;
                break;
            case 90:
                x=126f;
                y=84f;
                break;
            default:
                x=0.8f;
                y=84f;
                break;

        }

        float indentLeft=0.00f;
        coords[0]=x/256f-indentLeft;
        coords[1]=y/256f;
        coords[2]=x/256f+UVGlyphWidth;
        coords[3]=y/256f;
        coords[4]=x/256f+UVGlyphWidth;
        coords[5]=y/256f+UVGlyphHeight*1f;
        coords[6]=x/256f-indentLeft;
        coords[7]=y/256f+UVGlyphHeight*1f;


        return coords;
    }




}