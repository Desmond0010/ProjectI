package com.leaflea.johndoran.projecti;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;
/*
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_STRIP;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3f;
*/

public class ElectricRing extends Vehicles {

    public float[] getVertsCollide(){return getVertices();}

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
    float tempx;
    float tempy;
    float tempz;
    public static FloatBuffer mSecondRingVerts ;
    public static FloatBuffer mSecondRingColor ;
    public static ShortBuffer mSecondRingInd   ;

    public static MyRenderer MR;

    float tempx1;
    float tempy1;
    float tempz1;

    //public static float luck      =2f;
    //public static float armour    =1f;
    //public static float handling  =3f;
    //public static float size      =1f;
//
    //public float armourPlus=0;
    //public float handlingPlus=0;
    //public float luckPlus=0;
    //public float sizePlus=0;


    public int price=2000;
    public int bought=0;

    public float actualSize     = calculateSize();

    public Boolean notInitialized=true;

    public int stacks=80; //must be even//
    public int sides=20;
    public float radiusOfVehicle=2.5f*actualSize;
    public float radiusThicknessOfRingOne=0.4f*actualSize;
    public float radiusThicknessOfRingTwo=0.25f*actualSize;
    public float radiusOfVehicleInnerRing=radiusOfVehicle-radiusThicknessOfRingOne-radiusThicknessOfRingTwo;

    public float tempxInner=tempx*radiusOfVehicleInnerRing/radiusOfVehicle;
    public float tempyInner=tempy*radiusOfVehicleInnerRing/radiusOfVehicle;
    public float tempzInner=tempz*radiusOfVehicleInnerRing/radiusOfVehicle;

    float[] secondRingVertsArray=new float[stacks*sides*3];
    float[] secondRingColorArray=new float[stacks*sides*4];
    short[] secondRingIndArray  =new short[stacks*sides*6];


    public int noOfAdditionalVertexPoints=1;

    private float ratioOfYToXYMagnitude;
    private float magnitudeOfXAndY;
    private float lengthOfMagnitudeOfXAndY;

    private float[] tempMatrixVertices1=new float[sides*3];
    private float[] tempMatrixVertices2=new float[sides*3];
    public int ID_NUMBER=11;

    private GL10 gl;

    //renderController rC=new renderController();

    public ElectricRing(GL10 gl){
        MR=rC.getMR();
        this.gl=gl;
        //luck      =2f;
        //armour    =1f;
        //handling  =3f;
        //size      =1f;
        //armourPlus=0;
        //handlingPlus=0;
        //luckPlus=0;
        //sizePlus=0;

    }

    public ElectricRing(GL10 gl,float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot) {

        setVariables();

        armourPlus=0;
        handlingPlus=0;
        luckPlus=0;
        sizePlus=0;
        this.MR=rC.getMR();
        this.gl=gl;
        actualSize     = calculateSize();
        radiusOfVehicle=2.5f*actualSize;
        radiusThicknessOfRingOne=0.4f*actualSize;
        radiusThicknessOfRingTwo=0.25f*actualSize;
        radiusOfVehicleInnerRing=radiusOfVehicle-radiusThicknessOfRingOne-radiusThicknessOfRingTwo;
        tempxInner=tempx*radiusOfVehicleInnerRing/radiusOfVehicle;
        tempyInner=tempy*radiusOfVehicleInnerRing/radiusOfVehicle;
        tempzInner=tempz*radiusOfVehicleInnerRing/radiusOfVehicle;
        this.xpos=MotorX;
        this.ypos=MotorY;
        this.zpos=MotorZ;

        this.xrot=xrot;
        this.yrot=yrot;
        this.zrot=zrot;

        if (notInitialized) {

            redoInitialisation();
        }

        //Render( xpos, ypos, zpos, this.xrot, this.yrot, this.zrot);
    }
/*
    public ElectricRing(GL10 gl,Boolean f,float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot) {

        this.MR=rC.getMR();
        this.gl=gl;
        actualSize      =size-sizePlus*0.03f;
        radiusOfVehicle=2.5f*actualSize;
        radiusThicknessOfRingOne=0.4f*actualSize;
        radiusThicknessOfRingTwo=0.25f*actualSize;
        radiusOfVehicleInnerRing=radiusOfVehicle-radiusThicknessOfRingOne-radiusThicknessOfRingTwo;
        tempxInner=tempx*radiusOfVehicleInnerRing/radiusOfVehicle;
        tempyInner=tempy*radiusOfVehicleInnerRing/radiusOfVehicle;
        tempzInner=tempz*radiusOfVehicleInnerRing/radiusOfVehicle;
        this.xpos=MotorX;
        this.ypos=MotorY;
        this.zpos=MotorZ;

        this.xrot=xrot;
        this.yrot=yrot;
        this.zrot=zrot;

        if (notInitialized) {

            redoInitialisation();
        }

        Render( xpos, ypos, zpos, this.xrot, this.yrot, this.zrot);
    }
*/
    public void redoInitialisation(){


        actualSize     = calculateSize();
        radiusOfVehicle=2.5f*actualSize;
        radiusThicknessOfRingOne=0.4f*actualSize;
        radiusThicknessOfRingTwo=0.25f*actualSize;
        radiusOfVehicleInnerRing=radiusOfVehicle-radiusThicknessOfRingOne-radiusThicknessOfRingTwo;
        length=radiusOfVehicle*2f;
        tempxInner=tempx*radiusOfVehicleInnerRing/radiusOfVehicle;
        tempyInner=tempy*radiusOfVehicleInnerRing/radiusOfVehicle;
        tempzInner=tempz*radiusOfVehicleInnerRing/radiusOfVehicle;

        noOfVertices=3*(stacks+noOfAdditionalVertexPoints);







        vertices =new float[noOfVertices];
        //float[] model={0f,0f,0f,     0f,1f,0f,         1f,0f,0f,          1f,0f,1f,
        //		  0.2f,0f,1f,  0.3f,0.2f,0.95f,   0.8f,0f,1f,          0.7f,0.2f,0.95f };
        float[] model =new float[noOfVertices];
        for (int c=0;c<stacks/2;c++){

            tempx=radiusOfVehicle*2*((float)c/((float)stacks/2f))-radiusOfVehicle;
            tempy=(float)Math.sqrt((double)(radiusOfVehicle*radiusOfVehicle-tempx*tempx));
            tempz=0;

            //ok

            vertices[c*3+0		   ]=tempx;
            vertices[c*3+1         ]=tempy;
            vertices[c*3+2         ]=tempz;

            vertices[stacks*3/2+c*3+0]=-1f*tempx;
            vertices[stacks*3/2+c*3+1]=-1f*tempy;
            vertices[stacks*3/2+c*3+2]=tempz;

            //ok
        }
        vertices[stacks*3+0]=0;
        vertices[stacks*3+1]=0;
        vertices[stacks*3+2]=0;

        makeEverything();

        if(onetimething) {

            short[] test ={0,0,0,1,2,3};
            //setmSecondRingVerts(rC.vertexBufferGenerator(secondRingVertsArray));
            //setmSecondRingColor(rC.colorsBufferGenerator(secondRingColorArray));
            //setmSecondRingInd(rC.indexBufferGenerator(secondRingIndArray));
            //setmSecondRingInd(rC.indexBufferGenerator(test));

            //MR.setmVehicleSecondaryVerts(rC.vertexBufferGenerator(secondRingVertsArray));

            onetimething=false;
        }
        //MR.setUpVehicleBuffers();
        notInitialized=false;
    }
Boolean onetimething=true;

    float changer=0;
    public void Render(float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot){
        redoInitialisation();

        this.xpos=MotorX;
        this.ypos=MotorY;
        this.zpos=MotorZ;

        this.xrot=xrot;
        this.yrot=yrot;
        this.zrot=zrot;

        //makeEverything();

        gl.glPushMatrix();

            //glRotatef(-45f      ,xpos+2/2*width  ,ypos+1/2*height    ,zpos+1/2*length+5f  );


        //    gl.glRotatef(xrot / 90f, xpos + 1, ypos, zpos);
        //gl.glRotatef(yrot / 90f, xpos, ypos + 1, zpos);
        //gl.glRotatef(zrot / 90f, xpos, ypos, zpos + 1);



        gl.glColor4f(0, 1f, 0.5f, 1f);
        gl.glTranslatef(xpos, ypos, zpos);
        gl.glRotatef(xrot, 0,1f,0);
        gl.glRotatef(yrot, 1,0,0);
        gl.glRotatef(zrot, 0,0,1);

        //rC.drawWithBuffers(gl, true, MR.getmGold3Verts(), MR.getmGold3Color(), MR.getmGold3Ind(), 1);

            rC.drawWithBuffers(gl, true, MR
                    .getmVehicleVerts(), MR.getmVehicleColor(), MR.getmVehicleInd(), sides * stacks * 6);
            gl.glPushMatrix();



                changer=changer+5f;
                gl.glRotatef(zpos+changer, 1f, 0, 1f);

                //gl.glRotatef(zpos, 1f, 0, 1f);//use this one in game
                gl.glTranslatef(0, 0, 0);



                //rC.drawWithBuffers(gl, true, getmSecondRingVerts(), getmSecondRingColor(), getmSecondRingInd(), getModelIndices2().length);
                rC.drawWithBuffers(gl, true, MR.getmVehicleSecondaryVerts(), MR.getmVehicleSecondaryColor(), MR.getmVehicleSecondaryInd(),  getModelIndices2().length);


            gl.glPopMatrix();
        gl.glPopMatrix();
    }


    public float[] generateCircle(float tempx, float tempy, float tempz,float radius, int sides){
        float[] tempMatrixVertices=new float[sides*3];
        float tempx1;
        float tempy1;
        float tempz1;
        float ratioOfYToXYMagnitude;
        float lengthOfMagnitudeOfXAndY;
        float magnitudeOfXAndY=(float) Math.sqrt((double)(tempx*tempx+tempy*tempy));
        if (magnitudeOfXAndY>0){
            ratioOfYToXYMagnitude=tempy/magnitudeOfXAndY;

        }
        else{
            ratioOfYToXYMagnitude=1f;
        }

        //here a full circle of vertices is made.

        for (int d=0;d<((tempMatrixVertices.length)/2/3);d++){

            tempz1=2f*radius*(   ((d/(((float)tempMatrixVertices.length/3f/2f)))))   -radius ;

            lengthOfMagnitudeOfXAndY=(float)Math.sqrt((double)(radius*radius-tempz1*tempz1));

            tempy1=lengthOfMagnitudeOfXAndY*ratioOfYToXYMagnitude;
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



    public float[] getModel(){
        modelVertArray=new float[3*sides*stacks];

        actualSize     = calculateSize();
        radiusOfVehicle=2.5f*actualSize;
        radiusThicknessOfRingOne=0.4f*actualSize;
        radiusThicknessOfRingTwo=0.25f*actualSize;
        radiusOfVehicleInnerRing=radiusOfVehicle-radiusThicknessOfRingOne-radiusThicknessOfRingTwo;
        length=radiusOfVehicle*2f;
        tempxInner=tempx*radiusOfVehicleInnerRing/radiusOfVehicle;
        tempyInner=tempy*radiusOfVehicleInnerRing/radiusOfVehicle;
        tempzInner=tempz*radiusOfVehicleInnerRing/radiusOfVehicle;


        for (int c=0;c<stacks;c++) {

            tempx = vertices[c * 3 + 0];
            tempy = vertices[c * 3 + 1];
            tempz = vertices[c * 3 + 2];

            tempMatrixVertices1 = generateCircle(tempx, tempy, tempz, radiusThicknessOfRingOne, sides);

            for (int d=0;d<tempMatrixVertices1.length;d++) {
                modelVertArray[c * 3 * sides+d]=tempMatrixVertices1[d];
            }
        }
        return modelVertArray;
    }

    public float[] getModelColor(){
        modelColorArray=new float[4*sides*stacks];

        for (int c=0;c<stacks;c++) {
            for (int d=0;d<sides;d++) {
                modelColorArray[c * 4 * sides + d*4+0]=0.2f+(Math.abs((float)d/(float)sides-(float)sides/2f/(float)sides))*(1.4f);
                modelColorArray[c * 4 * sides + d*4+1]=0.3f+(Math.abs(((float)d/(float)sides-(float)sides/2f/(float)sides)))*(0.8f);
                modelColorArray[c * 4 * sides + d*4+2]=0.8f;
                modelColorArray[c * 4 * sides + d*4+3]=1;

            }
        }
        return modelColorArray;
    }

    public short[] getModelIndices(){
        modelIndArray=new short[sides*stacks*6];
        //A faster method is possible if GL_TRIANGLE_STRIP is used 0,10,1,11,.....9,19,0,10,20
        for (int c=0;c<stacks;c++) {
            for (int d=0;d<sides;d++) {
                modelIndArray[(c * sides+d)*6+0]=(short)(((c)  %stacks)* sides+(d  )%sides );
                modelIndArray[(c * sides+d)*6+1]=(short)(((c+1)%stacks)* sides+(d  )%sides );
                modelIndArray[(c * sides+d)*6+2]=(short)(((c)  %stacks)* sides+(d+1)%sides );//
                modelIndArray[(c * sides+d)*6+3]=(short)(((c+1)%stacks)* sides+(d  )%sides );
                modelIndArray[(c * sides+d)*6+4]=(short)(((c)  %stacks)* sides+(d+1)%sides );//
                modelIndArray[(c * sides+d)*6+5]=(short)(((c+1)%stacks)* sides+(d+1)%sides );//
            }
        }
        return modelIndArray;
    }

    public float[] getModelVertArray(){
        modelVertArray=new float[3*sides*stacks];

        actualSize     = calculateSize();
        radiusOfVehicle=2.5f*actualSize;
        radiusThicknessOfRingOne=0.4f*actualSize;
        radiusThicknessOfRingTwo=0.25f*actualSize;
        radiusOfVehicleInnerRing=radiusOfVehicle-radiusThicknessOfRingOne-radiusThicknessOfRingTwo;
        length=radiusOfVehicle*2f;
        tempxInner=tempx*radiusOfVehicleInnerRing/radiusOfVehicle;
        tempyInner=tempy*radiusOfVehicleInnerRing/radiusOfVehicle;
        tempzInner=tempz*radiusOfVehicleInnerRing/radiusOfVehicle;


        for (int c=0;c<stacks;c++) {

            tempx = vertices[c * 3 + 0];
            tempy = vertices[c * 3 + 1];
            tempz = vertices[c * 3 + 2];

            tempMatrixVertices1 = generateCircle(tempx, tempy, tempz, radiusThicknessOfRingOne, sides);

            for (int d=0;d<tempMatrixVertices1.length;d++) {
                modelVertArray[c * 3 * sides+d]=tempMatrixVertices1[d];
            }
        }
        //for (int c=0;c<modelVertArray.length;c++){

        //    modelVertArray[c]=0.1f;

        //}
        return modelVertArray;
    }

    public float[] getModelColorArray(){
        modelColorArray=new float[4*sides*stacks];

        for (int c=0;c<stacks;c++) {
            for (int d=0;d<sides;d++) {
                modelColorArray[c * 4 * sides + d*4+0]=0.2f+(Math.abs((float)d/(float)sides-(float)sides/2f/(float)sides))*(1.4f);
                modelColorArray[c * 4 * sides + d*4+1]=0.3f+(Math.abs(((float)d/(float)sides-(float)sides/2f/(float)sides)))*(0.8f);
                modelColorArray[c * 4 * sides + d*4+2]=0.8f;
                modelColorArray[c * 4 * sides + d*4+3]=1;

            }
        }
        return modelColorArray;
    }



    public short[] getModelIndArray(){
        modelIndArray=new short[sides*stacks*6];
        //A faster method is possible if GL_TRIANGLE_STRIP is used 0,10,1,11,.....9,19,0,10,20
        for (int c=0;c<stacks;c++) {
            for (int d=0;d<sides;d++) {
                modelIndArray[(c * sides+d)*6+0]=(short)(((c)  %stacks)* sides+(d  )%sides );
                modelIndArray[(c * sides+d)*6+1]=(short)(((c+1)%stacks)* sides+(d  )%sides );
                modelIndArray[(c * sides+d)*6+2]=(short)(((c)  %stacks)* sides+(d+1)%sides );
                modelIndArray[(c * sides+d)*6+3]=(short)(((c+1)%stacks)* sides+(d  )%sides );
                modelIndArray[(c * sides+d)*6+4]=(short)(((c)  %stacks)* sides+(d+1)%sides );
                modelIndArray[(c * sides+d)*6+5]=(short)(((c+1)%stacks)* sides+(d+1)%sides );
            }
        }
        return modelIndArray;
    }

    public float[] getModel2(){

        secondRingVertsArray=new float[3*sides*stacks];

        actualSize     = calculateSize();
        radiusOfVehicle=2.5f*actualSize;
        radiusThicknessOfRingOne=0.4f*actualSize;
        radiusThicknessOfRingTwo=0.25f*actualSize;
        radiusOfVehicleInnerRing=radiusOfVehicle-radiusThicknessOfRingOne-radiusThicknessOfRingTwo;
        length=radiusOfVehicle*2f;
        tempxInner=tempx*radiusOfVehicleInnerRing/radiusOfVehicle;
        tempyInner=tempy*radiusOfVehicleInnerRing/radiusOfVehicle;
        tempzInner=tempz*radiusOfVehicleInnerRing/radiusOfVehicle;


        for (int c=0;c<stacks;c++) {

            tempx = vertices[c * 3 + 0]*radiusOfVehicleInnerRing/radiusOfVehicle;
            tempy = vertices[c * 3 + 1]*radiusOfVehicleInnerRing/radiusOfVehicle;
            tempz = vertices[c * 3 + 2]*radiusOfVehicleInnerRing/radiusOfVehicle;

            tempMatrixVertices1 = generateCircle(tempx, tempy, tempz, radiusThicknessOfRingTwo, sides);

            for (int d=0;d<tempMatrixVertices1.length;d++) {
                secondRingVertsArray[c * 3 * sides+d]=tempMatrixVertices1[d];
            }
        }
        return secondRingVertsArray;
    }

    public float[] getModelColor2(){



        for (int c=0;c<stacks;c++) {
            for (int d=0;d<sides;d++) {
                secondRingColorArray[c * 4 * sides + d*4+0]=0.2f+(Math.abs((float)d/(float)sides-(float)sides/2f/(float)sides))*(1.4f);
                secondRingColorArray[c * 4 * sides + d*4+1]=0.3f+(Math.abs(((float)d/(float)sides-(float)sides/2f/(float)sides)))*(0.8f);
                secondRingColorArray[c * 4 * sides + d*4+2]=0.8f;
                secondRingColorArray[c * 4 * sides + d*4+3]=1f;

            }
        }
        return secondRingColorArray;
    }

    public short[] getModelIndices2(){
        //A faster method is possible if GL_TRIANGLE_STRIP is used 0,10,1,11,.....9,19,0,10,20
        for (int c=0;c<stacks;c++) {
            for (int d=0;d<sides;d++) {
                secondRingIndArray[(c * sides+d)*6+0]=(short)(((c)  %stacks)* sides+(d  )%sides );
                secondRingIndArray[(c * sides+d)*6+1]=(short)(((c+1)%stacks)* sides+(d  )%sides );
                secondRingIndArray[(c * sides+d)*6+2]=(short)(((c)  %stacks)* sides+(d+1)%sides );
                secondRingIndArray[(c * sides+d)*6+3]=(short)(((c+1)%stacks)* sides+(d  )%sides );
                secondRingIndArray[(c * sides+d)*6+4]=(short)(((c)  %stacks)* sides+(d+1)%sides );
                secondRingIndArray[(c * sides+d)*6+5]=(short)(((c+1)%stacks)* sides+(d+1)%sides );
            }
        }
        return secondRingIndArray;
    }

    public void makeEverything(){
        modelVertArray=getModelVertArray();
        modelColorArray=getModelColorArray();
        modelIndArray=getModelIndArray();

        secondRingVertsArray=getModel2();
        secondRingColorArray =getModelColor2();
        secondRingIndArray  = getModelIndices2();


        //remember to uncomment in set all buffers
    }


    public FloatBuffer getmSecondRingVerts() {
        return mSecondRingVerts;
    }

    public void setmSecondRingVerts(FloatBuffer mSecondRingVerts) {
        this.mSecondRingVerts = mSecondRingVerts;
    }

    public FloatBuffer getmSecondRingColor() {
        return mSecondRingColor;
    }

    public void setmSecondRingColor(FloatBuffer mSecondRingColor) {
        this.mSecondRingColor = mSecondRingColor;
    }

    public ShortBuffer getmSecondRingInd() {
        return mSecondRingInd;
    }

    public void setmSecondRingInd(ShortBuffer mSecondRingInd) {
        this.mSecondRingInd = mSecondRingInd;
    }
}
