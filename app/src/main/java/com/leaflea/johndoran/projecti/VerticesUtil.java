package com.leaflea.johndoran.projecti;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by John on 19/01/16.
 */
public  class VerticesUtil {


    /*
    public static float[] generateCircle(float tempx, float tempy, float tempz,float radius, int sides){
        float[] tempMatrixVertices=new float[sides*3];
        float tempx1;
        float tempy1;
        float tempz1;
        float SinYtoXY;
        float lengthOfMagnitudeOfXAndY;
        float magnitudeOfXAndY=(float) Math.sqrt((double)(tempx*tempx+tempy*tempy));
        if (magnitudeOfXAndY>0){
            SinYtoXY=tempy/magnitudeOfXAndY;

        }
        else{
            SinYtoXY=1f;
        }

        //here a full circle of vertices is made.

        for (int d=0;d<((tempMatrixVertices.length)/2/3);d++){

            tempz1=2f*radius*(   ((d/(((float)tempMatrixVertices.length/3f/2f)))))   -radius ;

            lengthOfMagnitudeOfXAndY=(float)Math.sqrt((double)(radius*radius-tempz1*tempz1));

            tempy1=lengthOfMagnitudeOfXAndY*SinYtoXY;
            if (tempx<0f){
                tempx1=-1f*(float)Math.sqrt((double)(lengthOfMagnitudeOfXAndY*lengthOfMagnitudeOfXAndY-tempy1*tempy1));
            }
            else{
                tempx1=1f*(float)Math.sqrt((double)(lengthOfMagnitudeOfXAndY*lengthOfMagnitudeOfXAndY-tempy1*tempy1));
            }

            tempMatrixVertices[d*3+0]=tempx+tempx1;
            tempMatrixVertices[d*3+1]=tempy+tempy1;
            tempMatrixVertices[d*3+2]=tempz+tempz1;

            tempx1=tempx1*-1f;
            tempy1=tempy1*-1f;
            tempz1=tempz1*-1f;

            tempMatrixVertices[d*3+0+(tempMatrixVertices.length)/2]=tempx+tempx1;
            tempMatrixVertices[d*3+1+(tempMatrixVertices.length)/2]=tempy+tempy1;
            tempMatrixVertices[d*3+2+(tempMatrixVertices.length)/2]=tempz+tempz1;
        }


        return tempMatrixVertices;
    }
    */

    public static float[] generateCircle(float xrot,float yrot, float radius, int sides){

        //float[] vertices=new float[sides*3+3];
        float[] vertices=new float[sides*3];

        if (xrot%90==0){
            xrot=xrot+0.001f;
        }
        if (yrot%90==0){
            yrot=yrot+0.001f;
        }
        float tanZtoY =(float)Math.tan(((double) xrot/57.2958f));//convert rotations to radians
        float tanXtoZ =(float)Math.tan(((double) yrot/57.2958f));//convert rotations to radians
        float sinZtoYZ=(float)Math.sin(((double) xrot / 57.2958f));//convert rotations to radians
        float sinXtoXZ=(float)Math.sin(((double) yrot / 57.2958f));//convert rotations to radians
        float cosZtoYZ=(float)Math.cos(((double) xrot / 57.2958f));//convert rotations to radians
        float cosXtoXZ=(float)Math.cos(((double) yrot / 57.2958f));//convert rotations to radians

        //float sinYtoX=(float)Math.tan(((double) zrot));

        float z=0;
        float x=radius;
        float y=0;

        /*
        for(int c=0;c<sides/2;c++){


            x=radius-(float)((float)c/((float)sides/4))*radius;
            //do x-axis rotation
            z=sinZtoYZ*(float)Math.sqrt((double)(radius*radius-x*x));
            y=(float)Math.sqrt((double)(radius*radius-x*x-z*z));


            //do y-axis rotation
            float tempmag=(float)Math.sqrt((double)(z*z+x*x));

            float pm=Math.abs(x)/x;
            if (Float.isNaN(pm)){
                pm=1;
            }
            x=pm*tempmag*sinXtoXZ;
            pm=Math.abs(z)/z;
            if (Float.isNaN(pm)){
                pm=1;
            }
            z=pm*tempmag*cosXtoXZ;
            //x=tempmag*sinXtoXZ;
            //z=tempmag*cosXtoXZ;

            if(radius*radius-x*x-z*z>0){
                y=(float)Math.sqrt((double)(radius*radius-x*x-z*z));
            }else{
                y=0;
            }
            vertices[c*3+0]=x;
            vertices[c*3+1]=y;
            vertices[c*3+2]=z;

            vertices[(c+sides/2)*3+0]=-x;
            vertices[(c+sides/2)*3+1]=-y;
            vertices[(c+sides/2)*3+2]=-z;



        }
        if (x<0.001f){
            x=0;
        }
        if (y<0.001f){
            y=0;

        }
        if (z<0.001f){
            z=0;
        }*/

        for(int c=0;c<sides/2;c++){
            z=0;
            x=radius-(float)((float)c/((float)sides/4))*radius;
            y=(float)Math.sqrt((double)(radius*radius-x*x-z*z));

            vertices[c*3+0]=x;
            vertices[c*3+1]=y;
            vertices[c*3+2]=z;

            vertices[(c+sides/2)*3+0]=-x;
            vertices[(c+sides/2)*3+1]=-y;
            vertices[(c+sides/2)*3+2]=-z;
        }



        //float y=radius*sinYtoXY*sinXtoXZ;
        //float x=(float)Math.pow(2,sinYtoXY*y)+(float)Math.pow(2,y);
//
        //float z=(float)Math.sqrt((double)(radius*radius-x*x-y*y));

        return vertices;
    }
    public static void renderSphere(GL10 gl,renderController rC,float radius,float yprop,float zprop, int slices, int stacks){

        rC.drawWithBuffers(gl, rC.vertexBufferGenerator(squash(generateSphere(0,0,radius,slices,stacks),yprop,zprop)), rC.indexBufferGenerator(generateSphereIndices(slices,stacks)), 1);

    }

    public static float[] squash(float verts[], float yprop,float zprop){
        float[] v=verts.clone();
        for(int c=0;c<v.length/3;c++){
            v[c*3+0]=v[c*3+0];
            v[c*3+1]=v[c*3+1]*yprop;
            v[c*3+2]=v[c*3+2]*zprop;
        }
        return v;
    }
    public static float[] generateSphere(float xrot,float yrot, float radius, int sides,int stacks){
        float[] vertices=new float[sides*stacks*3+2*3];
        float[] tempHolder=new float[sides*3];
        float YZmag=0;
        float x=0;
        for(int c=0;c<stacks;c++){
            x=-radius+2f*(float)c/(float)stacks*(radius);
            if ((double)radius*(double)radius-(double)x*(double)x<0){
                YZmag=0;
            }else{
            YZmag=(float)Math.sqrt((double)radius*(double)radius-(double)x*(double)x);}
            tempHolder=generateCircle(0,0,YZmag,sides);
            for(int d=0;d<sides;d++){
                vertices[((c*sides)+(d))*3+0]=tempHolder[d*3+0]+x;
                vertices[((c*sides)+(d))*3+1]=tempHolder[d*3+1];
                vertices[((c*sides)+(d))*3+2]=tempHolder[d*3+2];

            }

        }

        vertices[sides*stacks*3+0]=0-radius;
        vertices[sides*stacks*3+1]=0;
        vertices[sides*stacks*3+2]=0;

        vertices[sides*stacks*3+0]=0+radius;
        vertices[sides*stacks*3+1]=0;
        vertices[sides*stacks*3+2]=0;

        return vertices;
    }

    public static short[] generateSphereIndices(int sides,int stacks){
        int jump=1;
        short[] indices=new short[(stacks-1)*sides*6+2*sides*3];
        for(int c=0;c<(stacks-1);c++){

            for(int d=0;d<sides;d++){
                indices[((c*sides)+(d))*6+0]=(short)(((c%stacks))*sides+((d)%sides));
                indices[((c*sides)+(d))*6+1]=(short)(((c%stacks))*sides+((d+jump)%sides));
                indices[((c*sides)+(d))*6+2]=(short)(((c+jump)%stacks)*sides+((d+jump)%sides));

                indices[((c*sides)+(d))*6+3]=(short)(((c%stacks))*sides+((d)%sides));
                indices[((c*sides)+(d))*6+4]=(short)(((c+jump)%stacks)*sides+((d)%sides));
                indices[((c*sides)+(d))*6+5]=(short)(((c+jump)%stacks)*sides+((d+jump)%sides));
            }
        }

        for (int c=0;c<sides;c++){
            indices[(((stacks-1)*sides))*6+1*c*3+0]=(short)((c)%sides);
            indices[(((stacks-1)*sides))*6+1*c*3+1]=(short)((c+1)%sides);
            indices[(((stacks-1)*sides))*6+1*c*3+2]=(short)((c+1)%sides);
        }

        for (int c=0;c<sides;c++){
            indices[(((stacks-1)*sides))*6+sides*3+c*3+0]=(short)(sides*(stacks-1)+(short)((c)%sides));
            indices[(((stacks-1)*sides))*6+sides*3+c*3+1]=(short)(sides*(stacks-1)+(short)((c+1)%sides));
            indices[(((stacks-1)*sides))*6+sides*3+c*3+2]=(short)(stacks*sides+1);
        }

        return indices;
    }
    public static float[] generateCylinder1(float xrot,float yrot, float radius,float length, int sides,int stacks){
        float tanZtoY =(float)Math.tan(((double) xrot / 57.2958f));//convert rotations to radians
        float tanXtoZ =(float)Math.tan(((double) yrot / 57.2958f));//convert rotations to radians
        float sinZtoYZ=(float)Math.sin(((double) xrot / 57.2958f));//convert rotations to radians
        float sinXtoXZ=(float)Math.sin(((double) yrot / 57.2958f));//convert rotations to radians
        float cosZtoYZ=(float)Math.cos(((double) xrot / 57.2958f));//convert rotations to radians
        float cosXtoXZ=(float)Math.cos(((double) yrot / 57.2958f));//convert rotations to radians
        float[] vertices=new float[sides*stacks*3];
        float[] tempHolder=new float[stacks*3];
        float[] tempCircle=new float[sides*3];

        float x=0;
        float y=0;
        float z=0;
        for(int c=0;c<stacks;c++){
            x=0;
            y=0;
            z=(float)((float)c/(float)stacks*(float)length);

            //do x-axis rotation
            y=1f/tanZtoY*z;

            z=(float)Math.sqrt((double)(radius*radius-y*y-z*z));


            //do y-axis rotation
            float tempmag=(float)Math.sqrt((double)(z*z+x*x));

            float pm=Math.abs(x)/x;
            if (Float.isNaN(pm)){
                pm=1;
            }
            x=pm*tempmag*sinXtoXZ;
            pm=Math.abs(z)/z;
            if (Float.isNaN(pm)){
                pm=1;
            }
            z=pm*tempmag*cosXtoXZ;
            /*
            * x=(float)((float)c/(float)stacks*(float)length);
            y=0;
            z=0;

            //do x-axis rotation
            z=sinZtoYZ*(float)Math.sqrt((double)(radius*radius-x*x));
            y=(float)Math.sqrt((double)(radius*radius-x*x-z*z));


            //do y-axis rotation
            float tempmag=(float)Math.sqrt((double)(z*z+x*x));

            float pm=Math.abs(x)/x;
            if (Float.isNaN(pm)){
                pm=1;
            }
            x=pm*tempmag*sinXtoXZ;
            pm=Math.abs(z)/z;
            if (Float.isNaN(pm)){
                pm=1;
            }
            z=pm*tempmag*cosXtoXZ;///////////////////////////////////////////put comment here*/
            tempHolder[c*3+0]=x;
            tempHolder[c*3+1]=y;
            tempHolder[c*3+2]=z;
        }
        tempCircle=generateCircle(xrot,yrot,radius,sides);

        for(int c=0;c<stacks;c++){
            for(int d=0;d<sides;d++){
                vertices[((c*sides)+(d))*3+0]=tempHolder[c*3+0]+tempCircle[d*3+0];
                vertices[((c*sides)+(d))*3+1]=tempHolder[c*3+1]+tempCircle[d*3+1];
                vertices[((c*sides)+(d))*3+2]=tempHolder[c*3+2]+tempCircle[d*3+2];

            }

        }


        return vertices;
    }

        public static short[] generateCylinderIndices(int sides,int stacks){
        int jump=1;
        short[] indices=new short[(stacks-1)*sides*6+2*sides*3];
        for(int c=0;c<(stacks-1);c++){

            for(int d=0;d<sides;d++){
                indices[((c*sides)+(d))*6+0]=(short)(((c))*sides+((d)%sides));
                indices[((c*sides)+(d))*6+1]=(short)(((c))*sides+((d+jump)%sides));
                indices[((c*sides)+(d))*6+2]=(short)(((c+jump)%stacks)*sides+((d+jump)%sides));

                indices[((c*sides)+(d))*6+3]=(short)(((c))*sides+((d)%sides));
                indices[((c*sides)+(d))*6+4]=(short)(((c+jump)%stacks)*sides+((d)%sides));
                indices[((c*sides)+(d))*6+5]=(short)(((c+jump)%stacks)*sides+((d+jump)%sides));
            }
        }

            for(int c=0;c<sides;c++){
                indices[(stacks-1)*sides*6+c*3+0]=(short)(c);
                indices[(stacks-1)*sides*6+c*3+1]=(short)(((c+1))%sides);
                indices[(stacks-1)*sides*6+c*3+2]=(short)(((c+sides/2)%sides));
            }
            for(int c=0;c<sides;c++){
                indices[(stacks-1)*sides*6+(c+sides)*3+0]=(short)((stacks-1)*sides+c);
                indices[(stacks-1)*sides*6+(c+sides)*3+1]=(short)((stacks-1)*sides+((c+1))%sides);
                indices[(stacks-1)*sides*6+(c+sides)*3+2]=(short)((stacks-1)*sides+((c+sides/2)%sides));
            }


        return indices;
    }

    public static float[] generateCylinder(float xrot,float yrot, float radius,float length, int sides,int stacks) {

        float[] vertices=new float[sides*stacks*3];
        float x=0;
        float y=0;
        float z=0;
        float[] tempCircle;




        tempCircle=generateCircle(0,90,radius,sides);

        for(int c=0;c<stacks;c++){
            x=0;
            y=0;
            z=(float)(((float)c/(float)(stacks-1))*(float)length);
            for(int d=0;d<sides;d++){
                vertices[((c*sides)+(d))*3+0]=x+tempCircle[d*3+0];
                vertices[((c*sides)+(d))*3+1]=y+tempCircle[d*3+1];
                vertices[((c*sides)+(d))*3+2]=z+tempCircle[d*3+2];

            }

        }


        return vertices;

    }

    public static short[] generateCylinderIndicesPure(int sides,int stacks){//Includes enclosing  circle
        int jump=1;
        short[] indices=new short[(stacks-1)*sides*6+2*sides*3];
        for(int c=0;c<(stacks-1);c++){

            for(int d=0;d<sides;d++){
                indices[((c*sides)+(d))*6+0]=(short)(((c))*sides             +((d)%sides));
                indices[((c*sides)+(d))*6+1]=(short)(((c))*sides             +((d+jump)%sides));
                indices[((c*sides)+(d))*6+2]=(short)(((c+jump)%stacks)*sides +((d+jump)%sides));

                indices[((c*sides)+(d))*6+3]=(short)(((c))*sides             +((d)%sides));
                indices[((c*sides)+(d))*6+4]=(short)(((c+jump)%stacks)*sides +((d)%sides));
                indices[((c*sides)+(d))*6+5]=(short)(((c+jump)%stacks)*sides +((d+jump)%sides));
            }
        }

        for(int c=0;c<sides;c++){
            indices[((stacks-1)*sides)*6+c*3+0]=(short)(c);
            indices[((stacks-1)*sides)*6+c*3+1]=(short)(((c+1))%sides);
            indices[((stacks-1)*sides)*6+c*3+2]=(short)(((c+10)%sides));

            indices[((stacks-1)*sides)*6+c*3+0]=(short)(0);
            indices[((stacks-1)*sides)*6+c*3+1]=(short)(0);
            indices[((stacks-1)*sides)*6+c*3+2]=(short)(0);
        }
        for(int c=0;c<sides;c++){
            indices[(stacks-1)*sides*6+sides*3+c*3+0]=(short)((stacks-1)*sides+c);
            indices[(stacks-1)*sides*6+sides*3+c*3+1]=(short)((stacks-1)*sides+((c+1))%sides);
            indices[(stacks-1)*sides*6+sides*3+c*3+2]=(short)((stacks-1)*sides+((c+10)%sides));

            indices[(stacks-1)*sides*6+sides*3+c*3+0]=(short)(0);
            indices[(stacks-1)*sides*6+sides*3+c*3+1]=(short)(0);
            indices[(stacks-1)*sides*6+sides*3+c*3+2]=(short)(0);
        }


        return indices;
    }

}
