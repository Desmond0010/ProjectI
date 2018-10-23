package com.leaflea.johndoran.projecti;

/**
 * Created by John on 25/08/15.
 */

import javax.microedition.khronos.opengles.GL10;


public class The_Cube extends Vehicles
{


    public float[] getModel2(){
        return secondRingVertsArray;
    }
    public float[] getModelColor2(){
        return secondRingColorArray;
    }
    public short[] getModelIndices2(){
        return secondRingIndArray;
    }

    //public float[] getModelVertArray() {
    //    return modelVertArray;
    //}
    public float[] getModelVertArray(){

        return this.vertices;
    }
    public void setModelVertArray(float[] modelVertArray) {
        this.modelVertArray = modelVertArray;
    }

    public float[] getModelColorArray() {
        return modelColorArray;
    }

    public void setModelColorArray(float[] modelColorArray) {
        this.modelColorArray = modelColorArray;
    }

    public short[] getModelIndArray() {
        return modelIndArray;
    }

    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public int getBought() {
        return bought;
    }


    public void setBought(int bought) {
        this.bought = bought;
    }


    public Boolean getNotInitialized() {
        return notInitialized;
    }


    public void setNotInitialized(Boolean notInitialized) {
        this.notInitialized = notInitialized;
    }
    public float getArmourPlus() {
        return armourPlus;
    }


    public void setArmourPlus(float armourPlus) {
        this.armourPlus = armourPlus;
    }


    public float getHandlingPlus() {
        return handlingPlus;
    }


    public void setHandlingPlus(float handlingPlus) {
        this.handlingPlus = handlingPlus;
    }


    public float getLuckPlus() {
        return luckPlus;
    }


    public void setLuckPlus(float luckPlus) {
        this.luckPlus = luckPlus;
    }


    public float getSizePlus() {
        return sizePlus;
    }


    public void setSizePlus(float sizePlus) {
        this.sizePlus = sizePlus;
    }


    public int getID_NUMBER() {
        return ID_NUMBER;
    }


    public void setID_NUMBER(int iD_NUMBER) {
        ID_NUMBER = iD_NUMBER;
    }




    public float getXpos() {
        return xpos;
    }


    public void setXpos(float xpos) {
        this.xpos = xpos;
    }


    public float getYpos() {
        return ypos;
    }


    public void setYpos(float ypos) {
        this.ypos = ypos;
    }


    public float getZpos() {
        return zpos;
    }


    public void setZpos(float zpos) {
        this.zpos = zpos;
    }


    public float getLength() {
        return length;
    }


    public void setLength(float length) {
        this.length = length;
    }


    public float getWidth() {
        return width;
    }


    public void setWidth(float width) {
        this.width = width;
    }


    public float getHeight() {
        return height;
    }


    public void setHeight(float height) {
        this.height = height;
    }


    public float getXrot() {
        return xrot;
    }


    public void setXrot(float xrot) {
        this.xrot = xrot;
    }


    public float getYrot() {
        return yrot;
    }


    public void setYrot(float yrot) {
        this.yrot = yrot;
    }


    public float getZrot() {
        return zrot;
    }


    public void setZrot(float zrot) {
        this.zrot = zrot;
    }


    public float getXvel() {
        return xvel;
    }


    public void setXvel(float xvel) {
        this.xvel = xvel;
    }


    public float getYvel() {
        return yvel;
    }


    public void setYvel(float yvel) {
        this.yvel = yvel;
    }


    public float getZvel() {
        return zvel;
    }


    public void setZvel(float zvel) {
        this.zvel = zvel;
    }


    public float getWeight() {
        return weight;
    }


    public void setWeight(float weight) {
        this.weight = weight;
    }




    public float getHandling(){
        float[] v=MR.getHandlings();
        return v[ID_NUMBER];
    }
    public float getLuck(){

        float[] v=MR.getLucks();
        return v[ID_NUMBER];
    }
    public float getSize(){
        float[] v=MR.getSizes();
        return v[ID_NUMBER];
    }
    public float getArmour(){
        float[] v=MR.getArmours();
        return  v[ID_NUMBER];
    }


    public float[] getVertices() {
        return vertices;
    }


    public void setVertices(float[] vertices) {
        this.vertices = vertices;
    }


    public int getNoOfVertices() {
        return noOfVertices;
    }


    public void setNoOfVertices(int noOfVertices) {
        this.noOfVertices = noOfVertices;
    }
    public float[] getVertsCollide(){return vertices;}
    //public float[] getVertsCollide(){return getModelVertArray();}

    // public float xpos    =0;
    // public float ypos    =0;
    // public float zpos    =1000000;


    //public float luck =1f;
    //public float armour =1f;
    //public float handling=1f;
    //public float size=1f;

    //public float armourPlus=0;
    //public float handlingPlus=0;
    //public float luckPlus=0;
    //public float sizePlus=0;

    public int price=0;
    public int bought=1;

    public float actualSize     = calculateSize();
    public float length  =4*actualSize;
    public float width   =4*actualSize;
    public float height  =4*actualSize;



    public float xrot    =1;
    public float yrot    =1;
    public float zrot    =1;
    public Boolean notInitialized=true;



    public int ID_NUMBER=0;
    GL10 gl;

    public float[] secondRingVertsArray={0,0,0};
    public float[] secondRingColorArray={0,0,0,0};
    public short[] secondRingIndArray  ={0,0,0,0,0,0};

    public float[] colors={0,0,0,1f,    0,1f,0,1f,       0,0,0,1f,     0,0,0,1f,
            1f,0,0f,1f,    0,0,0,1f,       0,0,1f,1f,     0,0,0,1f};
    public short[] indices={
            0,1,3,   0,2,3,
            0,4,6,   0,2,6,
            0,1,5,   0,4,5,

            7,6,4,   7,5,4,
            7,3,1,   7,5,1,
            7,6,2,   7,3,2
    };
    float[] vertices={
            -width/2f  ,-height/2f ,-length/2f              ,width/2f , -height/2f ,-length/2f
            ,-width/2f ,height/2f ,-length/2f              ,width/2f , height/2f ,-length/2f
            ,-width/2f ,-height/2f ,length/2f              ,width/2f , -height/2f ,length/2f
            ,-width/2f ,height/2f ,length/2f              ,width/2f , height/2f ,length/2f};
   // renderController rC=new renderController();
    MyRenderer MR;
    public The_Cube(GL10 gl){
        this.MR=rC.getMR();
        this.gl=gl;
    }


    public The_Cube(GL10 gl,float The_CubeX,float The_CubeY,float The_CubeZ,float xrot,float yrot,float zrot) {
        setVariables();



        this.MR=rC.getMR();
        this.gl=gl;
        actualSize     = calculateSize();
        length  =4*actualSize;
        width   =4*actualSize;
        height  =4*actualSize;
        this.xpos=The_CubeX;
        this.ypos=The_CubeY;
        this.zpos=The_CubeZ;

        this.xrot=xrot;
        this.yrot=yrot;
        this.zrot=zrot;

        /*if (notInitialized){
            noOfVertices=8*3;
            vertices =new float[noOfVertices];
            //	vertices={0f,0f,0f,width,0f,0f,width,height,0f,0f,height,0f,0f,0f,length,width,0f,length,width,height,length,0f, height,length};
            for (int c=0;c<8;c++){
                vertices[c*3+0]=width*(float)(c%2);
                vertices[c*3+1]=height*(float)((Math.ceil((double)(c)/2d)%2));
                vertices[c*3+2]=length*(float)((Math.ceil((double)(c)/4d)%2));
            }
            notInitialized=false;
        }
        for (float c : vertices) {
            //   System.out.print( c+",");
        }
*/

/*

        modelVertArray=new float[vertices.length];
        for (int c=0;c< modelVertArray.length;c++) {
            modelVertArray[c]=vertices[c];
        }
        modelColorArray=new float[colors.length];
        for (int c=0;c< modelColorArray.length;c++) {
            modelColorArray[c]=colors[c];
        }
        modelIndArray=new short[indices.length];
        for (int c=0;c< modelIndArray.length;c++) {
            modelIndArray[c]=indices[c];
        }

        modelVertArray=vertices;
        modelColorArray=colors;
        modelIndArray=indices;
*/
        redoInitialisation();

        //Render( xpos, ypos, zpos, this.xrot, this.yrot, this.zrot);
    }



    public void Render(float xpos,float ypos,float zpos,float xrot,float yrot,float zrot){
       this.MR=rC.getMR();

        //redoInitialisation();
        this.xpos=xpos;this.ypos=ypos;this.zpos=zpos;this.xrot=xrot;this.yrot=yrot;this.zrot=zrot;

        gl.glPushMatrix();

            //gl.glRotatef(xrot, xpos + 2 / 2 * width + 1, ypos + 1 / 2 * height, zpos + 1 / 2 * length);
            //gl.glRotatef(yrot, xpos + 2 / 2 * width, ypos + 1 / 2 * height + 1, zpos + 1 / 2 * length);
            //gl.glRotatef(zrot, xpos + 2 / 2 * width, ypos + 1 / 2 * height, zpos + 1 / 2 * length + 1);
        gl.glTranslatef(xpos, ypos, zpos);


        gl.glRotatef(xrot, 0,1,0);
        gl.glRotatef(yrot, 1,0,0);
        gl.glRotatef(zrot, 0,0,1);


        gl.glColor4f(0.8f, 0.8f, 0.8f,1f);

        rC.drawWithBuffers(gl,true,MR.getmVehicleVerts(), MR.getmVehicleColor(), MR.getmVehicleInd(), 36);

        //rC.drawWithBuffers(gl,MR.getmVehicleVerts(), MR.getmVehicleInd(), 36);



        gl.glPopMatrix();


    }



    public float[] getModelVert(){
        /*float[] vertices={-width/2f,0f     ,0f                   ,width/2f ,0f     ,0f
                         ,-width/2f,height ,0f                   ,width/2f ,height ,0f
                         ,-width/2f,0f     ,length               ,width/2f ,0f     ,length
                         ,-width/2f,height ,length              ,width/2f  ,height ,length};*/
        float[] vertices={
                -width/2f  ,-height/2f ,-length/2f              ,width/2f , -height/2f ,-length/2f
                ,-width/2f ,height/2f ,-length/2f              ,width/2f , height/2f ,-length/2f
                ,-width/2f ,-height/2f ,length/2f              ,width/2f , -height/2f ,length/2f
                ,-width/2f ,height/2f ,length/2f              ,width/2f , height/2f ,length/2f};

        return vertices;
    }

    public float[] getModelColor(){
        float[] colors={0,0,0,1f,    0,1f,0,1f,       0,0,0,1f,     0,0,0,1f,
                1f,0,0f,1f,    0,0,0,1f,       0,0,1f,1f,     0,0,0,1f};
        return colors;
    }



    public short[] getModelInd(){
        short[] indices={
                0,1,3,   0,2,3,
                0,4,6,   0,2,6,
                0,1,5,   0,4,5,

                7,6,4,   7,5,4,
                7,3,1,   7,5,1,
                7,6,2,   7,3,2
        };

        return indices;
    }


    public void makeEverything (){





        this.vertices=vertices;
        this.colors=colors;
        this.indices=indices;

        modelVertArray  =getModelVert();
        modelColorArray =getModelColor();
        modelIndArray   =getModelInd();




        secondRingVertsArray=getModelVert();
        secondRingColorArray =getModelColor();
        secondRingIndArray   =getModelInd();
    }

    public void redoInitialisation(){
        actualSize     =calculateSize();
        length  =4*actualSize;
        width   =4*actualSize;
        height  =4*actualSize;
        makeEverything();
    }

}
