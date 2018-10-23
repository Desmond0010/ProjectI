package com.leaflea.johndoran.projecti;

/**
 * Created by John on 15/07/15.
 */
import javax.microedition.khronos.opengles.GL10;


public class Rock// extends MultiCuboids
{
    public float getX(){
        return xpos;

    }
    public float getY(){
        return ypos;

    }
    public float getZ(){
        return zpos;

    }
    public float getLength(int choiceL){
        return length[choiceL];

    }
    public float getWidth(int choiceW){
        return width[choiceW];

    }
    public float getHeight(int choiceH){
        return height[choiceH];

    }
    public int getno(){
        return no;
    }
    public float getXRot(int choiceRX){
        return xrot[choiceRX];
    }
    public float getYRot(int choiceRY){
        return xrot[choiceRY];
    }

    public float getZRot(int choiceRZ){
        return zrot[choiceRZ];
    }
    float xpos=0;
    float ypos=0;
    float zpos=0;
    int no=2;
    float[] length  =new float[no];
    float[] width   =new float[no];
    float[] height  =new float[no];
    float[] xrot    =new float[no];
    float[] yrot    =new float[no];
    float[] zrot    =new float[no];
    float xvel=0.1f;
    float yvel=0.00f;
    float zvel=0.00f;
    private float uniqueSig1;
    private float uniqueSig2;
    private float uniqueSig3;
    private Boolean sigDefined=false;
    public Rock(){}
    GL10 gl;

    static renderController rC=new renderController();
    static MyRenderer MR;
    public Rock(GL10 gl,float X,float Y, float Z) {



        this.MR=rC.getMR();
        this.gl=gl;

        this.gl=gl;
        this.xpos=X;
        this.ypos=Y;
        this.zpos=Z;
        xpos=xpos+xvel;
        ypos=ypos+yvel;
        zpos=zpos+zvel;
        //Render(xpos,ypos,zpos);
    }

    public static float[] vertices;
    public static float[] colors;
    public static short[] indices;

    public void makeEverything(){
        length[0]=8f/1.618f ;//width
        width[0] =8f*1.618f;//heigth
        height[0]=8f; //length/depth

        vertices=new float[8*3];
        float[] verts={
                0,0,0,
                1,0,0,
                0,1,0,
                1,1,0,
                0,0,1,
                1,0,1,
                0,1,1,
                1,1,1
        };
        for (int c=0;c<8;c++){
            vertices[c*3+0]=verts[c*3+0]*width[0];
            vertices[c*3+1]=verts[c*3+1]*height[0] ;
            vertices[c*3+2]=verts[c*3+2]*length[0];
        }
        colors=new float[8*4];
        for(int d=0;d<8;d++){
            colors[d*4+0]=0.7f;
            colors[d*4+1]=0.1f;
            colors[d*4+2]=0.7f;
            colors[d*4+3]=1;

        }
        short[] ind={
                0,1,3,
                0,2,3,
                0,1,5,
                0,4,5,
                0,4,6,
                0,2,6,

                7,6,4,
                7,5,4,
                7,6,2,
                7,3,2,
                7,3,1,
                7,5,1
        };
        setIndices(ind);
    }



    public void Render(GL10 gl,float X,float Y, float Z){
        length[0]=8f/1.618f ;//width
        width[0] =8f*1.618f;//heigth
        height[0]=8f; //length/depth

        if (!sigDefined){
            uniqueSig1=(float)Math.random()*0.8f+0.15f;
            uniqueSig2=(float)Math.random()*0.8f+0.15f;
            uniqueSig3=(float)Math.random()*0.8f+0.15f;
            sigDefined=true;
        }
        this.MR=rC.getMR();
        this.gl=gl;
        this.xpos=X;
        this.ypos=Y;
        this.zpos=Z;

        gl.glPushMatrix();
        gl.glTranslatef(xpos, ypos, zpos);
        //gl.glColor4f(0.5f*uniqueSig1/2f, 0.5f*uniqueSig2/2f, 0.5f*(uniqueSig3)/2f, 1f);
        gl.glColor4f(uniqueSig1, uniqueSig2, (uniqueSig3), 1f);


        for (int c=0;c<1;c++){

            //length[c]=6;
            //width[c]=6;
            //height[c]=6;
            xrot[c]=0;
            yrot[c]=0;
            zrot[c]=0;

            gl.glRotatef(xrot[c]           ,xpos+2/2*width[c]+1  ,ypos+1/2*height[c]    ,zpos+1/2*length[c]  );
            gl.glRotatef(yrot[c]          ,xpos+2/2*width[c]    ,ypos+1/2*height[c]+1  ,zpos+1/2*length[c]  );
            gl.glRotatef(zrot[c], xpos + 2 / 2 * width[c], ypos + 1 / 2 * height[c], zpos + 1 / 2 * length[c] + 1);


            //rC.drawWithBuffers(gl,true,MR.getmStandardCuboidVerts(),MR.getmStandardCuboidColor(),MR.getmStandardCuboidInd(),24);
            rC.drawWithBuffers(gl,MR.getmStandardCuboidVerts(),MR.getmStandardCuboidInd(),24);


            //gl.glColor4f(0.7f, 0.1f, 0.7f, 1f);
        }


        gl.glPopMatrix();
    }

    public float[] getVertices() {
        return vertices;
    }

    public void setVertices(float[] vertices) {
        this.vertices = vertices;
    }

    public float[] getColors() {
        return colors;
    }

    public void setColors(float[] colors) {
        this.colors = colors;
    }

    public short[] getIndices() {
        return indices;
    }

    public void setIndices(short[] indices) {
        this.indices = indices;
    }
}
