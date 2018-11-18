package com.leaflea.johndoran.projecti;

public class Miscellaneous extends Vehicles{

    //rotor

    public static int sides=20;
    public static int stacks=20;
    public static float[] rotorVerts(float radius){


        float[] center=new float[stacks*sides*3];

        for(int c=0;c<stacks;c++){
            float z=-radius+(float)c/(float)stacks*2f*radius;
            float mag=(float)Math.sqrt((double)((radius*radius)-  (Math.abs(z)) * (Math.abs(z))  ));
            float[] circle=VerticesUtil.generateCircle(0,0,mag,sides);

            float mul=(float)(stacks-c)/(float)stacks;
            for(int d=0;d<sides/2;d++){
                center[c*sides*3+d*3+0]=circle[d*3+0]*mul;
                center[c*sides*3+d*3+1]=circle[d*3+1]*mul;
                center[c*sides*3+d*3+2]=z*mul;

                center[c*sides*3+(d+sides/2)*3+0]=-1f*circle[(d+sides/2)*3+0]*mul;
                center[c*sides*3+(d+sides/2)*3+1]=-1f*circle[(d+sides/2)*3+1]*mul;
                center[c*sides*3+(d+sides/2)*3+2]=z*mul;
            }
        }

        float propTriLen=radius*1.5f;
        float propwidth=radius*0.5f;
        float propRectLen=radius*1.5f;

        float[] prop=
                {
                        0,0,0,
                        propTriLen,propwidth/2f,0,    propTriLen,-propwidth/2f,0,
                        propTriLen+propRectLen,propwidth/2f,0,    propTriLen+propRectLen,-propwidth/2f,0

                };
        float[] props=new float[prop.length*4];

        for(int c=0;c<prop.length/3;c++){
            props[prop.length*0+c*3+0]= prop[(c%(prop.length/3))*3+0];
            props[prop.length*0+c*3+1]= prop[(c%(prop.length/3))*3+1];
            props[prop.length*0+c*3+2]= prop[(c%(prop.length/3))*3+2];

            props[prop.length*1+c*3+0]=-prop[(c%(prop.length/3))*3+0];
            props[prop.length*1+c*3+1]= prop[(c%(prop.length/3))*3+1];
            props[prop.length*1+c*3+2]= prop[(c%(prop.length/3))*3+2];

            props[prop.length*2+c*3+0]= prop[(c%(prop.length/3))*3+1];
            props[prop.length*2+c*3+1]= prop[(c%(prop.length/3))*3+0];
            props[prop.length*2+c*3+2]= prop[(c%(prop.length/3))*3+2];

            props[prop.length*3+c*3+0]= prop[(c%(prop.length/3))*3+1];
            props[prop.length*3+c*3+1]=-prop[(c%(prop.length/3))*3+0];
            props[prop.length*3+c*3+2]= prop[(c%(prop.length/3))*3+2];
        }

        return concatArrays(center,props);
    }

    public static float[] rotorColor(float R,float G, float B){


        float[] center=new float[stacks*sides*4];

        //float R=255f/256f;
        //float G=128f/256f;
        //float B=0.25f    ;//Orange
        float[] color=new float[stacks*sides*4+5*4*4];

        for(int c=0;c<stacks*sides+20;c++){
            color[c*4+0]=R;
            color[c*4+1]=G;
            color[c*4+2]=B;
            color[c*4+3]=1f;
        }
        /*
        for(int c=0;c<stacks;c++){
            for(int d=0;d<sides/2;d++){
                center[c*sides*3+d*3+0]=R;
                center[c*sides*3+d*3+1]=G;
                center[c*sides*3+d*3+2]=B;
                center[c*sides*3+d*3+3]=1f;


                center[c*sides*3+(d+sides/2)*3+0]=R;
                center[c*sides*3+(d+sides/2)*3+1]=G;
                center[c*sides*3+(d+sides/2)*3+2]=B;
                center[c*sides*3+d*3+3]=1f;

            }
        }


        float[] prop=
                {
                        R,G,B,1f,
                        R,G,B,1f,R,G,B,1f,
                        R,G,B,1f,R,G,B,1f

                };
        float[] props=new float[prop.length*4];

        for(int c=0;c<prop.length/16;c++){
            props[prop.length*0+c*4+0]=prop[(c%(prop.length/16))*4+0];
            props[prop.length*0+c*4+1]=prop[(c%(prop.length/16))*4+1];
            props[prop.length*0+c*4+2]=prop[(c%(prop.length/16))*4+2];
            props[prop.length*0+c*4+3]=prop[(c%(prop.length/16))*4+3];


            props[prop.length*1+c*4+0]=prop[(c%(prop.length/16))*4+0];
            props[prop.length*1+c*4+1]=prop[(c%(prop.length/16))*4+1];
            props[prop.length*1+c*4+2]=prop[(c%(prop.length/16))*4+2];
            props[prop.length*1+c*4+3]=prop[(c%(prop.length/16))*4+3];


            props[prop.length*2+c*4+0]=prop[(c%(prop.length/16))*4+0];
            props[prop.length*2+c*4+1]=prop[(c%(prop.length/16))*4+1];
            props[prop.length*2+c*4+2]=prop[(c%(prop.length/16))*4+2];
            props[prop.length*2+c*4+3]=prop[(c%(prop.length/16))*4+3];


            props[prop.length*3+c*4+0]=prop[(c%(prop.length/16))*4+0];
            props[prop.length*3+c*4+1]=prop[(c%(prop.length/16))*4+1];
            props[prop.length*3+c*4+2]=prop[(c%(prop.length/16))*4+2];
            props[prop.length*3+c*4+3]=prop[(c%(prop.length/16))*4+3];

        }*/

        //return concatArrays(center,props);
        return color;
    }

    public static short[] rotorIndices(){

        short[] sphere=new short[sides*(stacks-1)*6];

        for(int c=0;c<stacks-1;c++){
            for(int d=0;d<sides;d++){
                sphere[c*sides*6+d*6+0]=(short)((c)*sides+(d)%sides);
                sphere[c*sides*6+d*6+1]=(short)((c+1)*sides+(d)%sides);
                sphere[c*sides*6+d*6+2]=(short)((c+1)*sides+(d+1)%sides);

                sphere[c*sides*6+d*6+3]=(short)((c)*sides+(d)%sides);
                sphere[c*sides*6+d*6+4]=(short)((c)*sides+(d+1)%sides);
                sphere[c*sides*6+d*6+5]=(short)((c+1)*sides+(d+1)%sides);

            }
        }

        short[] prop={
                0,1,2,
                1,3,4,
                1,2,4
        };

        short[] props=concatIndicesArrays(prop,concatIndicesArrays(prop,concatIndicesArrays(prop,prop)));
        return concatIndicesArrays(sphere,props);
    }
}
