package com.leaflea.johndoran.projecti;

import javax.microedition.khronos.opengles.GL10;


public class FlyingSaucer extends Vehicles {


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
    public int ID_NUMBER=10;
    public Boolean notInitialized=true;


    public float[] model;
    public float[] colors;
    public short[] indices;

    GL10 gl;
    MyRenderer MR;
    renderController rC=new renderController();

    public FlyingSaucer(GL10 gl,float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot) {

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
        length  =3*actualSize;
        width   =3*actualSize;
        height  =3*actualSize;
        generateModel();
        noOfVertices=model.length;

        vertices =new float[noOfVertices];
        for (int c=0;c<noOfVertices/3;c++){
            vertices[c*3+0]= model[c*3+1]*width;
            vertices[c*3+1]= model[c*3+2]*-height;
            vertices[c*3+2]= model[c*3+0]*-length;

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


    public void generateModel() {//I am making model as if it was pointing at me reverse all z- co-ordinates at the end
        actualSize = calculateSize();
        //float multiplier=0.045f;

        int sides=20;
        int capStacks=6;
        float capRadius=3f;
        float capStretchProp=1.75f;

        float slantHeight=capRadius*1f;
        float slantPos=capStretchProp*capRadius*(float)(capStacks-1)/(float)(capStacks)+slantHeight;

        float flatHeight=capRadius*0.2f;
        float bottomHeight=capRadius*0.5f;
        float bottomRawRadius=capRadius*2.5f;
        float bottomMultiple=bottomHeight/bottomRawRadius;
        float bottomPos=capStretchProp*capRadius*(float)(capStacks-1)/(float)(capStacks)+slantHeight+flatHeight;

        float[] capVerts=new float[sides*(capStacks+1) *3+3];
        float[] bottomVerts=new float[sides*(capStacks)*3+3];

        capVerts[0]=0;
        capVerts[1]=0;
        capVerts[2]=0;

        float[] circleVerts=VerticesUtil.generateCircle(0,0,1,sides);



        for(int c=0;c<capStacks;c++){
            float curHeight=capRadius-(float)c/(float)capStacks*capRadius;
            float curCircleRadius=(float)Math.sqrt((double)(capRadius*capRadius-curHeight*curHeight));

            float curBottomHeight=(float)c/(float)capStacks*bottomRawRadius;
            float curBottomCircleRadius=(float)Math.sqrt((double)(bottomRawRadius*bottomRawRadius-curBottomHeight*curBottomHeight));

            for(int d=0;d<sides;d++){
                capVerts[3+(c*sides+d)*3+0]=circleVerts[d*3+0]*curCircleRadius;
                capVerts[3+(c*sides+d)*3+1]=circleVerts[d*3+1]*curCircleRadius;
                capVerts[3+(c*sides+d)*3+2]=circleVerts[d*3+2]*curCircleRadius+capStretchProp*(-curHeight+capRadius);

                bottomVerts[(c*sides+d)*3+0]=circleVerts[d*3+0]*curBottomCircleRadius;
                bottomVerts[(c*sides+d)*3+1]=circleVerts[d*3+1]*curBottomCircleRadius;
                bottomVerts[(c*sides+d)*3+2]=circleVerts[d*3+2]*curBottomCircleRadius+bottomPos+curBottomHeight*bottomMultiple;

            }
        }
        for(int d=0;d<sides;d++){
            capVerts[sides*capStacks*3+3+(d)*3+0]=circleVerts[d*3+0]*bottomRawRadius;
            capVerts[sides*capStacks*3+3+(d)*3+1]=circleVerts[d*3+1]*bottomRawRadius;
            capVerts[sides*capStacks*3+3+(d)*3+2]=circleVerts[d*3+2]*bottomRawRadius+slantPos;

        }
        bottomVerts[sides*capStacks*3+0]=0;
        bottomVerts[sides*capStacks*3+1]=0;
        bottomVerts[sides*capStacks*3+2]=bottomPos+bottomHeight;

        model= concatArrays(capVerts,bottomVerts);

        /*

        indices point to each vertex on each circle, circle to next circle*12 and then enclose last circle, maybe with a point/

         */

        indices=new short[2*3+(sides+(sides*(capStacks*2))*2+sides)*3];

        for(int c=0;c<sides;c++){
            indices[c*3+0]=0;
            indices[c*3+1]=(short)(1+c%sides);
            indices[c*3+2]=(short)(1+(c+1)%sides);
        }
        int jump;
        for(int c=0;c<capStacks*2;c++){
            for(int d=0;d<sides;d++) {
                indices[sides*3+(c*sides+d) * 6 + 0] = (short) (1 +(c)*sides  + (d)     % sides);
                indices[sides*3+(c*sides+d) * 6 + 1] = (short) (1 +(c+1)*sides+ (d)     % sides);
                indices[sides*3+(c*sides+d) * 6 + 2] = (short) (1 +(c+1)*sides+ (d + 1) % sides);

                indices[sides*3+(c*sides+d )* 6 + 3] = (short) (1 +(c)*sides  + (d)     % sides);
                indices[sides*3+(c*sides+d )* 6 + 4] = (short) (1 +(c)*sides  + (d+1)   % sides);
                indices[sides*3+(c*sides+d )* 6 + 5] = (short) (1 +(c+1)*sides+ (d + 1) % sides);
            }
        }

        for(int c=0;c<sides;c++){
            indices[sides*3+(capStacks*2)*sides * 6+c*3+0]=(short)(1+sides*(capStacks*2+1));
            indices[sides*3+(capStacks*2)*sides * 6+c*3+1]=(short)(1+sides*(capStacks*2)+c%sides);
            indices[sides*3+(capStacks*2)*sides * 6+c*3+2]=(short)(1+sides*(capStacks*2)+(c+1)%sides);
        }


        colors=new float[model.length/3*4];
        for(int c=0;c<colors.length/4;c++){
            colors[c*4+0]=((float)c*0.011f)%1f;
            colors[c*4+1]=((float)c*0.007f)%1f;
            colors[c*4+2]=((float)c*0.003f)%1f;
            colors[c*4+3]=1f;
            colors[c*4+0]=0.7f;
            colors[c*4+1]=0.7f;
            colors[c*4+2]=0.7f;
            colors[c*4+3]=1f;
        }

        for(int c=0;c<(capStacks-1)*sides+1;c++){
            colors[c*4+0]=0.9f;
            colors[c*4+1]=0.9f;
            colors[c*4+2]=0.9f;
            colors[c*4+3]=1f;
        }

        for(int c=(capStacks-1)*sides+1;c<(capStacks+1)*sides+1;c++){
            colors[c*4+0]=43f /256f;
            colors[c*4+1]=206f/256f;
            colors[c*4+2]=91f /256f;
            colors[c*4+3]=1f;
        }

        for(int c=(capStacks+1)*sides+1;c<model.length/3;c++){
            colors[c*4+0]=0f;
            colors[c*4+1]=0f;
            colors[c*4+2]=0f;
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

        r=r+4f;
        gl.glPushMatrix();
        {

            gl.glTranslatef(xpos, ypos, zpos);
            gl.glPushMatrix();
            {
                gl.glRotatef(r,0,1f,0);


                gl.glRotatef(xrot, 0,1,0);
                gl.glRotatef(yrot, 1,0,0);
                gl.glRotatef(zrot, 0,0,1);

                rC.drawWithBuffers(gl, true, MR.getmVehicleVerts(), MR.getmVehicleColor(), MR.getmVehicleInd(), 36);

            }gl.glPopMatrix();
        }
        gl.glPopMatrix();
    }

}
