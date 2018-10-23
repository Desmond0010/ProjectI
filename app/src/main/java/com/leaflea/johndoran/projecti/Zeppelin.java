package com.leaflea.johndoran.projecti;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by John on 22/06/16.
 */
public class Zeppelin extends Vehicles {



    public float[] getModelVertArray() {
        return modelVertArray;
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
    public void setModelIndArray(short[] modelIndArray) {
        this.modelIndArray = modelIndArray;
    }

    public int getPrice() {
        return price;
    }
    public void setNoOfVertices(int noOfVertices) {
        this.noOfVertices = noOfVertices;
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



    public float[] getVertices() {
        return vertices;
    }


    public void setVertices(float[] vertices) {
        this.vertices = vertices;
    }


    public int getNoOfVertices() {
        return noOfVertices;
    }

    public float[] getVertsCollide(){return vertices;}
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


    public int price=8000;
    public int bought=0;
    public float actualSize;
    public int ID_NUMBER=5;
    public Boolean notInitialized=true;


    public float[] model;
    public float[] colors;
    public short[] indices;

    GL10 gl;
    MyRenderer MR;
    renderController rC=new renderController();

    float multiplier=5f;
    public Zeppelin(GL10 gl,float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot) {

        MR=rC.getMR();
        this.gl=gl;
        setVariables();

        actualSize     =calculateSize();

        this.xpos=MotorX;
        this.ypos=MotorY;
        this.zpos=MotorZ;

        this.xrot=xrot;
        this.yrot=yrot;
        this.zrot=zrot;

        if (notInitialized) {

            redoInitialisation();
        }

    }


    public void redoInitialisation() {
        actualSize     =calculateSize()*0.1f;
        length  =3*actualSize* multiplier;
        width   =3*actualSize* multiplier;
        height  =3*actualSize* multiplier;
        generateModel();
        noOfVertices=model.length;

        vertices =new float[noOfVertices];
        for (int c=0;c<noOfVertices/3;c++){
            vertices[c*3+0]= model[c*3+0]*width;
            vertices[c*3+1]= model[c*3+1]*height;
            vertices[c*3+2]= model[c*3+2]*length;

            //vertices[c*3+0]= model[c*3+0]*width;
            //vertices[c*3+1]= model[c*3+1]*height;
            //vertices[c*3+2]= model[c*3+2]*-length;
        }

        notInitialized=false;


        modelVertArray=new float[vertices.length];
        for (int c=0;c< modelVertArray.length;c++) {
            modelVertArray[c]=vertices[c];
        }
        setModelColorArray(new float[colors.length]);
        for (int c=0;c< modelColorArray.length;c++) {
            modelColorArray[c]=colors[c];
        }
        setModelIndArray(new short[indices.length]);
        for (int c=0;c< modelIndArray.length;c++) {
            modelIndArray[c]=indices[c];
        }
        //MR.setUpVehicleBuffers();
    }


    public void generateModel() {//near to far -  model coordinates
        actualSize = calculateSize();

        int sides=10;
        int endStacks=10;//(at each end)
        float flatLength=1f;

        float radius=0.7f;
        float backLength=radius*4f;
        float frontLength=radius*backLength/2f;


        float[] balloon=new float[sides*(endStacks*2)*3];
        float[] circleVerts=VerticesUtil.generateCircle(0,0,1,sides);

        for(int c=0;c<endStacks;c++){

            float z=(float)(endStacks-1-c)/(float)(endStacks-1);
            float xandy=(float)Math.sqrt(1d-(double)z*z);
            for(int d=0;d<sides;d++){
                balloon[(c*sides+d)*3+0]=radius*circleVerts[d*3+0]*xandy;
                balloon[(c*sides+d)*3+1]=radius*circleVerts[d*3+1]*xandy;
                balloon[(c*sides+d)*3+2]=circleVerts[d*3+2]+(1-z)*backLength;

                balloon[((c+endStacks)*sides+d)*3+0]=radius*circleVerts[d*3+0]*z+0;
                balloon[((c+endStacks)*sides+d)*3+1]=radius*circleVerts[d*3+1]*z+0;
                balloon[((c+endStacks)*sides+d)*3+2]=circleVerts[d*3+2]+backLength+flatLength+(xandy)*frontLength;
            }
        }



        float wingSpan=radius*2f;
        float wingZPosition=backLength*0.5f;
        float wingThickness=backLength*0.15f*actualSize;

        int wingCylSides=sides;
        int wingCylStacks=endStacks;

        float[] wingCylVertices=VerticesUtil.generateCylinder(0,0,wingThickness,wingSpan,wingCylSides,wingCylStacks);
        float hold;
        float rot=0;
        for(int c=0;c<wingCylVertices.length/3;c++){
            hold=wingCylVertices[c*3+2];
            wingCylVertices[c*3+2]=wingCylVertices[c*3+0];
            wingCylVertices[c*3+0]=hold;

            //float mag=(float)Math.sqrt((double)(wingCylVertices[c*3+0]*wingCylVertices[c*3+0]+wingCylVertices[c*3+2]*wingCylVertices[c*3+2]));            float totalrot=rot;
            //wingCylVertices[c*3+0]=mag*(float)Math.sin(Math.toRadians(totalrot));
            //wingCylVertices[c*3+2]=mag*(float)Math.cos(Math.toRadians(totalrot));//This could go wrong direction


        }

        for(int c=0;c<wingCylStacks;c++){
            for(int d=0;d<wingCylSides;d++) {


                wingCylVertices[c * wingCylSides*3 +d * 3 + 1] = wingCylVertices[c * wingCylSides*3 +d * 3 + 1]*(0.3f);
            }
        }


        float[] wings=new float[wingCylVertices.length*4];
        for(int c=0;c<wingCylVertices.length/3;c++){
            wings[wingCylVertices.length*0+c*3+0]=wingCylVertices[c*3+0];
            wings[wingCylVertices.length*0+c*3+1]=wingCylVertices[c*3+1];
            wings[wingCylVertices.length*0+c*3+2]=wingCylVertices[c*3+2]+wingZPosition;

            wings[wingCylVertices.length*1+c*3+0]=-wingCylVertices[c*3+0];
            wings[wingCylVertices.length*1+c*3+1]=wingCylVertices[c*3+1];
            wings[wingCylVertices.length*1+c*3+2]=wingCylVertices[c*3+2]+wingZPosition;

            wings[wingCylVertices.length*2+c*3+0]=wingCylVertices[c*3+1];
            wings[wingCylVertices.length*2+c*3+1]=wingCylVertices[c*3+0];
            wings[wingCylVertices.length*2+c*3+2]=wingCylVertices[c*3+2]+wingZPosition;

            wings[wingCylVertices.length*3+c*3+0]=wingCylVertices[c*3+1];
            wings[wingCylVertices.length*3+c*3+1]=-wingCylVertices[c*3+0];
            wings[wingCylVertices.length*3+c*3+2]=wingCylVertices[c*3+2]+wingZPosition;

        }

        short[] balloonInd=new short[wingCylSides*(2*endStacks)*6];

        for(int c=0;c<endStacks*2-1;c++){
            for(int d=0;d<wingCylSides;d++) {
                balloonInd[(c*wingCylSides+d)*6+0]=(short)((c)*wingCylSides+(d)%wingCylSides);
                balloonInd[(c*wingCylSides+d)*6+1]=(short)((c)*wingCylSides+(d+1)%wingCylSides);
                balloonInd[(c*wingCylSides+d)*6+2]=(short)((c+1)*wingCylSides+(d+1)%wingCylSides);

                balloonInd[(c*wingCylSides+d)*6+3]=(short)((c)*wingCylSides+(d)%wingCylSides);
                balloonInd[(c*wingCylSides+d)*6+4]=(short)((c+1)*wingCylSides+(d)%wingCylSides);
                balloonInd[(c*wingCylSides+d)*6+5]=(short)((c+1)*wingCylSides+(d+1)%wingCylSides);
            }
        }

        short[] wingInd=VerticesUtil.generateCylinderIndices(wingCylSides,wingCylStacks);

        model=concatArrays(balloon,wings);
        indices=concatIndicesArrays(balloonInd,
                concatIndicesArrays(
                        wingInd
                        ,concatIndicesArrays(wingInd,concatIndicesArrays(wingInd,wingInd)))
        );
        colors=new float[model.length/3*4];

        for(int c=0;c<colors.length/4;c++){
            colors[c*4+0]=0.6f+((float)c*0.008f)%0.2f;
            colors[c*4+1]=0.6f+((float)c*0.008f)%0.2f;
            colors[c*4+2]=0.6f+((float)c*0.008f)%0.2f;
            colors[c*4+3]=1f;
        }

    }


    float r=0;
    public void Render(float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot){

        redoInitialisation();
        MR=rC.getMR();
        this.xpos=MotorX;
        this.ypos=MotorY;
        this.zpos=MotorZ;

        //r=r+5f;
        gl.glPushMatrix();
        {

            gl.glTranslatef(xpos, ypos, zpos);
            gl.glPushMatrix();
            {
                //gl.glRotatef(r,0,1f,0);

                gl.glRotatef(xrot, 0,1,0);
                gl.glRotatef(yrot, 1,0,0);
                gl.glRotatef(zrot, 0,0,1);
                rC.drawWithBuffers(gl, true, MR.getmVehicleVerts(), MR.getmVehicleColor(), MR.getmVehicleInd(), 36);

            }gl.glPopMatrix();
        }
        gl.glPopMatrix();
    }


}
