package com.leaflea.johndoran.projecti;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by John on 21/06/16.
 */
public class SpaceShuttle extends Vehicles{

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
    public int ID_NUMBER=9;
    public Boolean notInitialized=true;


    public float[] model;
    public float[] colors;
    public short[] indices;

    GL10 gl;
    MyRenderer MR;
    renderController rC=new renderController();

    public SpaceShuttle(GL10 gl,float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot) {

        MR=rC.getMR();
        this.gl=gl;
        setVariables();


        actualSize     =calculateSize();
        length  =10*actualSize;
        width   =3*actualSize;
        height  =3*actualSize;

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
        actualSize     =calculateSize();
        length  =10*actualSize;
        width   =3*actualSize;
        height  =3*actualSize;
        generateModel();
        noOfVertices=model.length;

        vertices =new float[noOfVertices];
        for (int c=0;c<noOfVertices/3;c++){
            vertices[c*3+0]= model[c*3+0]*width;
            vertices[c*3+1]= model[c*3+1]*height;
            vertices[c*3+2]= model[c*3+2]*-length;
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


    public void generateModel() {//I am making model as if it was pointing at me reverse all z- co-ordinates at the end
        actualSize = calculateSize();
        float multiplier=0.045f;
        float radius=3f*multiplier;
        float cylLength=10f*multiplier;
        float coneLength=2f*multiplier;
        float boosterPosDown=coneLength+cylLength*0.4f;
        float boosterShiftFromCentre=radius*1.1f;
        float boosterRadius=2f*multiplier;
        float boosterRadiusMultiplier=boosterRadius/radius;
        float boosterLength=7f*multiplier;
        float boosterLengthMultiplier=boosterLength/cylLength;
        int sides=20;
        int stacks=2;


        float[] centre=VerticesUtil.generateCylinder(0,0,radius,cylLength,sides,stacks);
        float[] point={0,0,0};
        for(int c=0;c<centre.length/3;c++){//I can add slop here
            centre[c*3+2]=centre[c*3+2]+coneLength;
        }
        float[] rocketVert=concatArrays(point,centre);

        model=concatArrays(rocketVert,concatArrays(rocketVert,
                concatArrays(rocketVert,concatArrays(rocketVert,concatArrays(rocketVert,rocketVert)))));
        for(int c=0;c<rocketVert.length/3;c++){
            model[rocketVert.length*1+c*3+0]=model[rocketVert.length*1+c*3+0]*boosterRadiusMultiplier+boosterShiftFromCentre;
            model[rocketVert.length*1+c*3+1]=model[rocketVert.length*1+c*3+1]*boosterRadiusMultiplier+boosterShiftFromCentre;
            model[rocketVert.length*1+c*3+2]=model[rocketVert.length*1+c*3+2]*boosterLengthMultiplier+boosterPosDown;

            model[rocketVert.length*2+c*3+0]=model[rocketVert.length*2+c*3+0]*boosterRadiusMultiplier-boosterShiftFromCentre;
            model[rocketVert.length*2+c*3+1]=model[rocketVert.length*2+c*3+1]*boosterRadiusMultiplier+boosterShiftFromCentre;
            model[rocketVert.length*2+c*3+2]=model[rocketVert.length*2+c*3+2]*boosterLengthMultiplier+boosterPosDown;

            model[rocketVert.length*3+c*3+0]=model[rocketVert.length*3+c*3+0]*boosterRadiusMultiplier-boosterShiftFromCentre;
            model[rocketVert.length*3+c*3+1]=model[rocketVert.length*3+c*3+1]*boosterRadiusMultiplier-boosterShiftFromCentre;
            model[rocketVert.length*3+c*3+2]=model[rocketVert.length*3+c*3+2]*boosterLengthMultiplier+boosterPosDown;

            model[rocketVert.length*4+c*3+0]=model[rocketVert.length*4+c*3+0]*boosterRadiusMultiplier+boosterShiftFromCentre;
            model[rocketVert.length*4+c*3+1]=model[rocketVert.length*4+c*3+1]*boosterRadiusMultiplier-boosterShiftFromCentre;
            model[rocketVert.length*4+c*3+2]=model[rocketVert.length*4+c*3+2]*boosterLengthMultiplier+boosterPosDown;

        }
        short[] coneInd=new short[sides*3];
        for(int c=0;c<sides;c++){
            coneInd[c*3+0]=(short)0;
            coneInd[c*3+1]=(short)(1+c);
            coneInd[c*3+2]=(short)(1+(c+1)%sides);
        }
        //DO NOT use concatIndArray as that would mess up code
        short[] rocketInd=concatArrays(coneInd, increaseValueOfAllElements(VerticesUtil.generateCylinderIndices(sides, stacks), (short)1));

        indices=concatIndicesArrays(rocketInd,concatIndicesArrays(rocketInd,concatIndicesArrays(rocketInd,concatIndicesArrays(rocketInd,rocketInd))));

        colors=new float[model.length/3*4];
        int centreRocketPoints= rocketVert.length/3;
        for(int c=0;c<centreRocketPoints;c++){
            colors[c*4+0]=0.1f;
            colors[c*4+1]=0.1f;
            colors[c*4+2]=0.1f;
            colors[c*4+3]=1f;
        }

        for(int c=centreRocketPoints;c<colors.length/4;c++){
            colors[c*4+0]=0.8f+((float)c*0.011f)%0.2f;
            colors[c*4+1]=0.8f+((float)c*0.007f)%0.2f;
            colors[c*4+2]=0.8f+((float)c*0.003f)%0.2f;
            colors[c*4+3]=1f;
        }
    }


    public void Render(float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot){

        redoInitialisation();
        MR=rC.getMR();
        this.xpos=MotorX;
        this.ypos=MotorY;
        this.zpos=MotorZ;

        gl.glPushMatrix();
        {
            gl.glTranslatef(xpos,ypos,zpos	);
            gl.glRotatef(xrot, 0,1,0);
            gl.glRotatef(yrot, 1,0,0);
            gl.glRotatef(zrot, 0,0,1);

            rC.drawWithBuffers(gl,true,MR.getmVehicleVerts(),MR.getmVehicleColor(),MR.getmVehicleInd(),36);
        }
        gl.glPopMatrix();
    }

}
