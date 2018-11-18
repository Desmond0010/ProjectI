package com.leaflea.johndoran.projecti;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public abstract class Vehicles {


	/*
	 * When creating a new vehicle :
	 *
	 * 1. Copy all of these getters and setters.
	 * 2. Create a menu page for it.
	 * 3. Add to touch detection.
	 * 4. Also add it to the ship overview page.
	 * 5. Create instance of it in MyRenderer.
	 * 6. Add ID number.
	 * 7. Add all of its variables to the streams.
	 */

    /*
	 * Vehicles :
	 *
	 *                       ID
	 ** 1.  The_Cube         0
	 ** 2.  Motor            1
	 ** 3.  Electric Ring    11
	 ** 4.  Paper Plane      2
	 ** 5.  Vintage Plane    6  - Rental
	 ** 6.  PassengerPlane   8
	 ** 7.  Hang Glider      3
	 * 8.  Space Shuttle    9
	 * 9.  Flying Saucer    10
	 * 10. Zepplin          5
	 * 11. Toy Airplane     4
	 * 12. WarPlane         7
	 *
	 *
	 * The_Cube
	 * Motor
	 * Paper Plane
	 * Hang Glider
	 * Toy Airplane
	 * Zepplin
	 * Vintage Plane
	 * WarPlane
	 * PassengerPlane
	 * Space Shuttle
	 * Flying Saucer
	 * Electric Ring
	 *
	 *
	 * Remember to correct IDs
	 */

    MyRenderer MR;


    public Boolean getNotInitialized() {
        return notInitialized;
    }

    public float[] getVertsCollide(){return getModelVertArray();}


    public FloatBuffer getVehicleVerticesBuffer() {
        return MR.getmVehicleVerts();
    }

    public FloatBuffer getVehicleColorBuffer(){
        return MR.getmVehicleColor();
    }
    public ShortBuffer getVehicleIndicesBuffer(){
        return MR.getmVehicleInd();
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


    public void setNoOfVertices(int noOfVertices) {
        this.noOfVertices = noOfVertices;
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
    public int price=0;
    public int bought=1;


    public float span=-1f;//this is the furthest distance from the middle of the vehicle to a point

    public Boolean notInitialized=true;
    public float xpos    =0;
    public float ypos    =0;
    public float zpos    =0;
    public float length  =3;
    public float width   =3;
    public float height  =3;
    public float xrot    =1;
    public float yrot    =1;
    public float zrot    =1;
    public float xvel=0;
    public float yvel=0;
    public float zvel=0;
    public float weight=20;  //tonnes

    public float armour  =1;
    public float handling=1;
    public float luck    =1;
    public float size    =1;

    public float armourPlus=0;
    public float handlingPlus=0;
    public float luckPlus=0;
    public float sizePlus=0;

    public int ID_NUMBER=0;
    public float[] vertices;
    public int noOfVertices;

    float[] secondRingVertsArray={0,0,0};
    float[] secondRingColorArray={0,0,0,0};
    short[] secondRingIndArray  ={0,0,0,0,0,0};

    renderController rC=new renderController();

    public float[] modelVertArray;
    public float[] modelColorArray;
    public short[] modelIndArray;

    Vehicles(){
        this.MR=rC.getMR();
    }


    public void makeEverything(){}
    public void Render(float xpos,float ypos,float zpos,float xrot,float yrot,float zrot) {


    }

    public void redoInitialisation(){}

    public float[] getModelVertArray() {
        return modelVertArray;
    }

    public void setModelVertArray(float[] modelVertArray) {
        this.modelVertArray = modelVertArray;
    }

    public  void fixVerts(){
        float maxX=0;
        float maxY=0;
        float maxZ=0;
        float minX=0;
        float minY=0;
        float minZ=0;

        float[] ve=this.getModelVertArray();
        for(int c=0;c<ve.length/3;c++){
            if(ve[c*3+0]<minX){
                minX=ve[c*3+0];
            }else if(ve[c*3+0]>maxX){
                maxX=ve[c*3+0];
            }

            if(ve[c*3+1]<minY){
                minY=ve[c*3+1];
            }else if(ve[c*3+1]>maxY){
                maxY=ve[c*3+1];
            }

            if(ve[c*3+2]<minZ){
                minZ=ve[c*3+2];
            }else if(ve[c*3+2]>maxZ){
                maxZ=ve[c*3+2];
            }
        }

        float difX=maxX-Math.abs(minX);
        float difY=maxY-Math.abs(minY);
        float difZ=maxZ-Math.abs(minZ);
        float propX=1f;
        float propY=1f;
        float propZ=1f;

        for(int c=0;c<ve.length/3;c++) {
            ve[c*3+0]=(ve[c*3+0]-difX/2f)*propX;
            ve[c*3+1]=(ve[c*3+1]-difY/2f)*propY;
            ve[c*3+2]=(ve[c*3+2]-difZ/2f)*propZ;
        }
        this.setModelVertArray(ve);

        ve=this.getModel2();




        for(int c=0;c<ve.length/3;c++) {
            ve[c*3+0]=(ve[c*3+0]-difX/2f)*propX;
            ve[c*3+1]=(ve[c*3+1]-difY/2f)*propY;
            ve[c*3+2]=(ve[c*3+2]-difZ/2f)*propZ;
        }


        this.setSecondRingVertsArray(ve);

    }
    public float getHandling(){
        float[] v=MyRenderer.getHandlings();
        return v[ID_NUMBER];

    }
    public float getLuck(){
        float[] v=MyRenderer.getLucks();
        return v[ID_NUMBER];


    }
    public float getSize(){
        float[] v=MyRenderer.getSizes();
        return v[ID_NUMBER];

    }
    public float getArmour(){
        float[] v=MyRenderer.getArmours();
        return  v[ID_NUMBER];


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

    public float calculateSize(){
        //return (float)(Math.pow(0.7d,(double)(this.size+this.sizePlus)));
        return 1f;
    }

    public void setVariables(){
        luck=getLuck();
        handling =getHandling();
        size=getSize();
        armour=getArmour();
    }
    public void setModelIndArray(short[] modelIndArray) {
        this.modelIndArray = modelIndArray;
    }


    public float[] getModel2(){
        return secondRingVertsArray;
    }
    public float[] getModelColor2(){
        return secondRingColorArray;
    }
    public short[] getModelIndices2(){
        return secondRingIndArray;
    }



    public static short[] concatIndicesArrays(short[] on, short[] tw){
        short[] one=on.clone();
        short[] two=tw.clone();

        short[] product=concatArrays(one,increaseValueOfAllElements(two,(short)(findMaxElement(one)+1)));
        return product;
    }

    public static short[] concatIndicesArrays1(short[] one, short[] two){

        short[] product=concatArrays(one,increaseValueOfAllElements(two,(short)(findMaxElement(one)+1)));
        return product;
    }
    public static float[] concatArrays(float[] on,float[] tw){
        float[] one=on.clone();
        float[] two=tw.clone();

        float[] product=new float[one.length+two.length];
        for(int c=0;c<(one.length);c++){
            product[c]=one[c];
        }
        for(int c=0;c<(two.length);c++){
            product[one.length+c]=two[c];
        }

        return product;
    }
    public static short[] concatArrays(short[] on,short[] tw){
        short[] one=on.clone();
        short[] two=tw.clone();
        short[] product=new short[one.length+two.length];
        for(int c=0;c<(one.length);c++){
            product[c]=one[c];
        }
        for(int c=0;c<(two.length);c++){
            product[one.length+c]=two[c];
        }

        return product;
    }

    public static short findMaxElement(short[] arr){
        short maxNum;
        if(arr.length>0){
            maxNum=arr[0];
            for(int c=0;c<arr.length;c++){
                if(maxNum<arr[c]){
                    maxNum=arr[c];
                }
            }
            return maxNum;
        }else {
            return 0;
        }
    }

    public static short[] increaseValueOfAllElements(short[] ar,short increase){

        short[] one=ar.clone();
        for(int c=0;c<one.length;c++){
            one[c]=(short)(one[c]+increase);
        }

        return one;
    }

    public void setSecondRingVertsArray(float[] secondRingVertsArray) {
        this.secondRingVertsArray = secondRingVertsArray;
    }

    public void setSecondRingColorArray(float[] secondRingColorArray) {
        this.secondRingColorArray = secondRingColorArray;
    }

    public void setSecondRingIndArray(short[] secondRingIndArray) {
        this.secondRingIndArray = secondRingIndArray;
    }
}

