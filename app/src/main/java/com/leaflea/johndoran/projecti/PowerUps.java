package com.leaflea.johndoran.projecti;

import javax.microedition.khronos.opengles.GL10;

public class PowerUps extends Gold{

    public static float[] getGemVerts() {
        return gemVerts;
    }

    public static void setGemVerts(float[] gemVerts) {
        PowerUps.gemVerts = gemVerts;
    }

    public static float[] getGemColors() {
        return gemColors;
    }

    public static void setGemColors(float[] gemColors) {
        PowerUps.gemColors = gemColors;
    }

    public static short[] getGemIndices() {
        return gemIndices;
    }

    public static void setGemIndices(short[] gemIndices) {
        PowerUps.gemIndices = gemIndices;
    }

    public int getFramesUntilCollisionsNormal() {
        return framesUntilCollisionsNormal;
    }
    public void setFramesUntilCollisionsNormal(int framesUntilCollisionsNormal) {
        this.framesUntilCollisionsNormal = framesUntilCollisionsNormal;
    }
    public float getX(){
        return xpos;

    }
    public float getY(){
        return ypos;

    }
    public float getZ(){
        return zpos;

    }
    public static float getLength(){
        return length;

    }
    public  static float getWidth(){
        return width;

    }
    public static float getHeight(){
        return height;

    }
    private static float length  =30f;
    private static float width   =length;
    private static float height  =length;

    public int value =4;


    private int framesUntilCollisionsNormal=400;
    //static Texture FRONTFACE= LoadTexture("walls_plain-highdef");

    GL10 gl;
    MyRenderer MR;
    renderController rC=new renderController();


    public PowerUps(){

    }
    public PowerUps(GL10 gl){
        this.gl=gl;
        MR=rC.getMR();
    }
    public PowerUps(GL10 gl,float X, float Y, float Z, int value) {
        //super(X, Y, Z, value);
        this.value=value;
        this.gl=gl;
        MR=rC.getMR();
        this.xpos=X;
        this.ypos=Y;
        this.zpos=Z;


        switch(value){


            case 1:

                //RenderPowerUp();
                break;

            case 2:
                //RenderPowerUp();
                break;

            case 3:
                //RenderPowerUp();
                break;

            case 4:
                renderPowerUp(R.drawable.goldface);
                break;

            case 5:
                framesUntilCollisionsNormal=500;
                renderPowerUp(R.drawable.invincibilityface);
                break;

            case 6:
                framesUntilCollisionsNormal=300;
                renderPowerUp(R.drawable.speedyface);
                break;

            case 7:
                framesUntilCollisionsNormal=600;
                renderPowerUp(R.drawable.magnetface);
                break;

            case 8:
                renderGem(X,Y,Z);
                break;
            default:
                renderPowerUp(R.drawable.goldface);
        }

    }


    public void renderPowerUp(int textureName){

        gl.glEnable(GL10.GL_TEXTURE);

        gl.glPushMatrix();

        gl.glTranslatef(xpos+length/2f,ypos,zpos+length/2f);

        gl.glColor4f(1,1,1,1f);
        rC.drawWithBuffers(gl,MR.getmStandardCuboidVerts(),MR.getmUVCoordsStandardCuboid(),MR.getmStandardCuboidInd(),24,textureName);
        //if using this method change mSandardCuboid Verts


        gl.glPopMatrix();


    }

    static float r=0;
    public void renderGem(float X,float Y,float Z){
        this.xpos=X;
        this.ypos=Y;
        this.zpos=Z;

        gl.glPushMatrix();

        gl.glTranslatef(X,Y,Z);

        r=r+6f;

        gl.glRotatef(r, 0, 1, 0);
        //gl.glColor4f(1, 1, 1, 1f);
        //if using this method change mSandardCuboid Verts

        rC.drawWithBuffers(gl,true,MR.getmGemVerts(),MR.getmGemColor(),MR.getmGemInd(),3);


        gl.glPopMatrix();
    }



    public static float[] gemVerts;
    public static float[] gemColors;
    public static short[] gemIndices;

    public static void generateGem(){
        int gemSides=8;
        float ringHeightProportion=.7f;
        float radius=length/2f;

        gemVerts=new float[(gemSides+2)*3];

        gemVerts[0]=0;
        gemVerts[1]=0;
        gemVerts[2]=00;
        gemVerts[(1+gemSides)*3+0]=0;
        gemVerts[(1+gemSides)*3+1]=radius*2f;
        gemVerts[(1+gemSides)*3+2]=0;
        for(int c=0;c<gemSides/2;c++){

            float x=-radius+2f *radius*(float)c/ ((float)gemSides/2f) ;
            float z=(float)Math.sqrt((double)(radius*radius-x*x));
            gemVerts[(1+c)*3+0]=x+0;
            gemVerts[(1+c)*3+1]=radius*2f*ringHeightProportion;
            gemVerts[(1+c)*3+2]=z+0;

            gemVerts[(1+gemSides/2+c)*3+0]=-x+0;
            gemVerts[(1+gemSides/2+c)*3+1]=radius*2f*ringHeightProportion;
            gemVerts[(1+gemSides/2+c)*3+2]=-z+0;
        }

        gemColors=new float[(gemSides+2)*4];


        gemColors[0]=80f/256f;
        gemColors[1]=90f/256f;
        gemColors[2]=222f/256f;
        gemColors[3]=0.7f;

        gemColors[(gemSides+1)*4+0]=80f/256f;
        gemColors[(gemSides+1)*4+1]=90f/256f;
        gemColors[(gemSides+1)*4+2]=222f/256f;
        gemColors[(gemSides+1)*4+3]=0.7f;

        for(int c=1;c<(gemSides+1);c++){//these are the colors for the ring
            gemColors[c*4+0]=70f/256f;
            gemColors[c*4+1]=232f/256f;
            gemColors[c*4+2]=(126f+(float)(c-1)/(float)(gemSides)*90f)/256f;
            gemColors[c*4+3]=0.7f;
        }

        gemIndices=new short[(gemSides)*2*3];

        for(int c=0;c<gemSides;c++){
            gemIndices[c*3+0]=(short)(0);
            gemIndices[c*3+1]=(short)((c)%gemSides+1);
            gemIndices[c*3+2]=(short)((c+1)%gemSides+1);

            gemIndices[(gemSides+c)*3+0]=(short)(gemSides+1);
            gemIndices[(gemSides+c)*3+1]=(short)((c)%gemSides+1);
            gemIndices[(gemSides+c)*3+2]=(short)((c+1)%gemSides+1);

        }
    }


    public  void renderPowerUp(int value,float X, float Y, float Z,Boolean useValue){//this is what i actually use

        this.xpos=X;
        this.ypos=Y;
        this.zpos=Z;
        this.value=value;

        int textureName=R.drawable.couriernewtextureatlastesttwo;

        float textureHeight=0.125f;
        float TX;
        float TY;
        switch (value) {

            case 4:
                TX=0.5f;
                TY=0.875f;
                break;

            case 5:

                framesUntilCollisionsNormal=500;
                TX=0.625f;
                TY=0.875f;
                break;

            case 6:
                framesUntilCollisionsNormal=300;
                TX=0.75f;
                TY=0.875f;
                break;

            case 7:
                framesUntilCollisionsNormal=600;
                TX=0.875f;
                TY=0.875f;
                break;

            default:
                TX=0;
                TY=0.75f;
        }

        /*float[] textureCoords={
                TX+0 *textureHeight,TY+0*textureHeight,
                TX+1f*textureHeight,TY+0*textureHeight,
                TX+0 *textureHeight,TY+1*textureHeight,
                TX+1 *textureHeight,TY+1*textureHeight,
                0f, 0f,
                0f, 0f,
                0f,0f,
                0f,0f
        };*/



        float[] textureCoords=new float[UVCoords.length];
        for(int c=0;c<UVCoords.length/2;c++){
            textureCoords[c*2+0]=UVCoords[c*2+0]*textureHeight+TX;
            textureCoords[c*2+1]=UVCoords[c*2+1]*textureHeight+TY;
        }

        gl.glEnable(GL10.GL_TEXTURE);

        gl.glPushMatrix();

        gl.glTranslatef(X,Y,Z);

        gl.glColor4f(1,1,1,1f);
        //rC.drawWithBuffers(gl,MR.getmStandardCuboidVerts(),MR.getmUVCoordsStandardCuboid(),MR.getmStandardCuboidInd(),24,textureName);
        //rC.drawWithBuffers(gl,MR.getmStandardCuboidVerts(),rC.uvBufferGenerator(textureCoords),MR.getmStandardCuboidInd(),24,textureName);
        //rC.drawWithBuffers(gl,rC.vertexBufferGenerator(CubeVerts),rC.uvBufferGenerator(textureCoords),MR.getmStandardCuboidInd(),24,textureName);
        rC.drawWithBuffers(gl,rC.vertexBufferGenerator(CubeVerts),rC.uvBufferGenerator(textureCoords),rC.indexBufferGenerator(powerUpInd),24,textureName);



        gl.glPopMatrix();


    }
/*
    public float[] UVCoords={0f,0f,1f,0f,0f,1f,1f,1f,0f,0f,0f,0f,0f,0f,0f,0f};
    public float[] CubeVerts={
            0*length,0*length,0*length,
            1*length,0*length,0*length,
            0*length,1*length,0*length,
            1*length,1*length,0*length,
            0*length,0*length,1*length,
            1*length,0*length,1*length,
            0*length,1*length,1*length,
            1*length,1*length,1*length
}
    ;

    */


    public float[] UVCoords={
            0.05f,0.05f,
            0.01f,0f,
            0f,0.01f,
            0.01f,0.01f,

            0.02f,0f,
            0f,0.02f,
            0.02f,0.02f,
            0f,0f,

            0f,0f,
            1f,0f,
            0f,1f,
            1f,1f};
    public float[] CubeVertsCool={
            0*length,0*length,0*length,
            1*length,0*length,0*length,
            0*length,1*length,0*length,
            1*length,1*length,0*length,
            0*length,0*length,1*length,
            1*length,0*length,1*length,
            0*length,1*length,1*length,
            1*length,1*length,1*length,
            0*length      ,0*length      ,-0.001f*length,
            1.001f*length ,0*length      ,-0.001f*length,
            0*length      ,1.001f*length ,-0.001f*length,
            1.001f*length ,1.001f*length ,-0.001f*length
    };

    public float[] CubeVerts={
            0*length,0*length,0*length,
            1*length,0*length,0*length,
            0*length,1*length,0*length,
            1*length,1*length,0*length,

            0*length,0*length,1*length,
            1*length,0*length,1*length,
            0*length,1*length,1*length,
            1*length,1*length,1*length,

            0*length      ,0*length      ,-0.3f*length,
            1.001f*length ,0*length      ,-0.3f*length,
            0*length      ,1.001f*length ,-0.3f*length,
            1.001f*length ,1.001f*length ,-0.3f*length
    };
    public short[] powerUpInd={
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
            7,5,1,

            8,9 ,11,
            8,10,11
    };

   /* private void  RenderGOLDCHEST(){

        FRONTFACE=LoadTexture("GOLD-face");

        glEnable(GL_TEXTURE);

        glPushMatrix();

        glTranslatef(X,Y,Z);
        glBegin(GL_QUADS);{

            glTexCoord2f(0f,0f);glVertex3f(0        ,0     	 	  ,0);
            glTexCoord2f(1f,0f);glVertex3f(width    ,0      	  ,0);
            glTexCoord2f(1f,1f);glVertex3f(width    ,height 	  ,0);
            glTexCoord2f(0f,1f);glVertex3f(0        ,height 	  ,0);

            glVertex3f(0        ,0      	  ,length);
            glVertex3f(width    ,0            ,length);
            glVertex3f(width    ,height       ,length);
            glVertex3f(0        ,height       ,length);

            glVertex3f(0        ,0            ,0);
            glVertex3f(0        ,height       ,0);
            glVertex3f(0        ,height       ,length);
            glVertex3f(0        ,0            ,length);

            glVertex3f(width    ,0            ,0);
            glVertex3f(width    ,height       ,0);
            glVertex3f(width    ,height       ,length);
            glVertex3f(width    ,0            ,length);

            glVertex3f(0        ,0     	 	  ,0);
            glVertex3f(width    ,0      	  ,0);
            glVertex3f(width    ,0 	          ,length);
            glVertex3f(0        ,0 	          ,length);

            glVertex3f(0        ,height   	  ,0);
            glVertex3f(width    ,height       ,0);
            glVertex3f(width    ,height 	  ,length);
            glVertex3f(0        ,height 	  ,length);


        }glEnd();
        glPopMatrix();

        glDisable(GL_TEXTURE);
        FRONTFACE.release();
    }
    private void  RenderINVINCIBILITY(){
        FRONTFACE=LoadTexture("INVINCIBILITY-face");

        glEnable(GL_TEXTURE);

        glPushMatrix();

        glTranslatef(X,Y,Z);
        glBegin(GL_QUADS);{

            glTexCoord2f(0f,0f);glVertex3f(0        ,0     	 	  ,0);
            glTexCoord2f(1f,0f);glVertex3f(width    ,0      	  ,0);
            glTexCoord2f(1f,1f);glVertex3f(width    ,height 	  ,0);
            glTexCoord2f(0f,1f);glVertex3f(0        ,height 	  ,0);

            glVertex3f(0        ,0      	  ,length);
            glVertex3f(width    ,0            ,length);
            glVertex3f(width    ,height       ,length);
            glVertex3f(0        ,height       ,length);

            glVertex3f(0        ,0            ,0);
            glVertex3f(0        ,height       ,0);
            glVertex3f(0        ,height       ,length);
            glVertex3f(0        ,0            ,length);

            glVertex3f(width    ,0            ,0);
            glVertex3f(width    ,height       ,0);
            glVertex3f(width    ,height       ,length);
            glVertex3f(width    ,0            ,length);

            glVertex3f(0        ,0     	 	  ,0);
            glVertex3f(width    ,0      	  ,0);
            glVertex3f(width    ,0 	          ,length);
            glVertex3f(0        ,0 	          ,length);

            glVertex3f(0        ,height   	  ,0);
            glVertex3f(width    ,height       ,0);
            glVertex3f(width    ,height 	  ,length);
            glVertex3f(0        ,height 	  ,length);


        }glEnd();
        glPopMatrix();

        glDisable(GL_TEXTURE);
        FRONTFACE.release();

    }
    private void  RenderSPEEDY(){
        FRONTFACE=LoadTexture("SPEEDY-face");

        glEnable(GL_TEXTURE);

        glPushMatrix();

        glTranslatef(X,Y,Z);
        glBegin(GL_QUADS);{

            glTexCoord2f(0f,0f);glVertex3f(0        ,0     	 	  ,0);
            glTexCoord2f(1f,0f);glVertex3f(width    ,0      	  ,0);
            glTexCoord2f(1f,1f);glVertex3f(width    ,height 	  ,0);
            glTexCoord2f(0f,1f);glVertex3f(0        ,height 	  ,0);

            glVertex3f(0        ,0      	  ,length);
            glVertex3f(width    ,0            ,length);
            glVertex3f(width    ,height       ,length);
            glVertex3f(0        ,height       ,length);

            glVertex3f(0        ,0            ,0);
            glVertex3f(0        ,height       ,0);
            glVertex3f(0        ,height       ,length);
            glVertex3f(0        ,0            ,length);

            glVertex3f(width    ,0            ,0);
            glVertex3f(width    ,height       ,0);
            glVertex3f(width    ,height       ,length);
            glVertex3f(width    ,0            ,length);

            glVertex3f(0        ,0     	 	  ,0);
            glVertex3f(width    ,0      	  ,0);
            glVertex3f(width    ,0 	          ,length);
            glVertex3f(0        ,0 	          ,length);

            glVertex3f(0        ,height   	  ,0);
            glVertex3f(width    ,height       ,0);
            glVertex3f(width    ,height 	  ,length);
            glVertex3f(0        ,height 	  ,length);


        }glEnd();
        glPopMatrix();

        glDisable(GL_TEXTURE);
        FRONTFACE.release();

    }

    private void  RenderMAGNET(){

        FRONTFACE=LoadTexture("MAGNET-face");

        glEnable(GL_TEXTURE);

        glPushMatrix();

        glTranslatef(X,Y,Z);
        glBegin(GL_QUADS);{

            glTexCoord2f(0f,0f);glVertex3f(0        ,0     	 	  ,0);
            glTexCoord2f(1f,0f);glVertex3f(width    ,0      	  ,0);
            glTexCoord2f(1f,1f);glVertex3f(width    ,height 	  ,0);
            glTexCoord2f(0f,1f);glVertex3f(0        ,height 	  ,0);

            glVertex3f(0        ,0      	  ,length);
            glVertex3f(width    ,0            ,length);
            glVertex3f(width    ,height       ,length);
            glVertex3f(0        ,height       ,length);

            glVertex3f(0        ,0            ,0);
            glVertex3f(0        ,height       ,0);
            glVertex3f(0        ,height       ,length);
            glVertex3f(0        ,0            ,length);

            glVertex3f(width    ,0            ,0);
            glVertex3f(width    ,height       ,0);
            glVertex3f(width    ,height       ,length);
            glVertex3f(width    ,0            ,length);

            glVertex3f(0        ,0     	 	  ,0);
            glVertex3f(width    ,0      	  ,0);
            glVertex3f(width    ,0 	          ,length);
            glVertex3f(0        ,0 	          ,length);

            glVertex3f(0        ,height   	  ,0);
            glVertex3f(width    ,height       ,0);
            glVertex3f(width    ,height 	  ,length);
            glVertex3f(0        ,height 	  ,length);


        }glEnd();
        glPopMatrix();

        glDisable(GL_TEXTURE);
        FRONTFACE.release();
    }


    public static Texture LoadTexture(String Key){
        try {
            return TextureLoader.getTexture("PNG", new FileInputStream(new File("res/"+Key+".png")));
        } catch (FileNotFoundException e) {

            e.printStackTrace();
            return null;
        } catch (IOException e) {

            e.printStackTrace();
            return null;

        }
    }
    */

    public float[] getUVCoords() {
        return UVCoords;
    }

    public void setUVCoords(float[] UVCoords) {
        this.UVCoords = UVCoords;
    }

    @Override
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
