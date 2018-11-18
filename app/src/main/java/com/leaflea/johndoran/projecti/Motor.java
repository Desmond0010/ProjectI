package com.leaflea.johndoran.projecti;


import javax.microedition.khronos.opengles.GL10;

public class Motor extends Vehicles {

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
    //public float luck      =1.5f;
    //public float armour    =2f;
    //public float handling  =1.5f;
    //public float size      =1f;
//
    //public float armourPlus=0;
    //public float handlingPlus=0;
    //public float luckPlus=0;
    //public float sizePlus=0;



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




    public int price=1000;
    public int bought=0;
    public float actualSize     = calculateSize();
    public int ID_NUMBER=1;
    public Boolean notInitialized=true;

    public float[] model={-0.5f,  0f,0f,   0.5f  ,0f,0f,               -0.5f,  1f,  0f,            0.5f,  1f,  0f,
                          -0.3f,0f,1f,   0.3f,0f,1f,               -0.2f,0.2f,0.95f,         0.2f,0.2f,0.95f    };

    //public float[] model={0f,  0f,0f,   1f  ,0f,0f,               0f,  1f,  0f,            1f,  1f,  0f,
    //        0.2f,0f,1f,   0.8f,0f,1f,               0.3f,0.2f,0.95f,         0.7f,0.2f,0.95f    };

    public float[] colors={0,0,0,1f,    0,0,0,1f,       0,0,0,1f,     0,0,0,1f,
            0,1f,0,1f,    0,1f,0,1f,       0,1f,0,1f,     0,1f,0,1f};
    public short[] indices={
            0,1,3,   0,2,3,
            0,4,6,   0,2,6,
            0,1,5,   0,4,5,

            7,6,4,   7,5,4,
            7,3,1,   7,5,1,
            7,6,2,   7,3,2
    };

    public Motor(GL10 gl){
        MR=rC.getMR();
        this.gl=gl;

    }

    GL10 gl;
    MyRenderer MR;
    renderController rC=new renderController();

    public Motor(GL10 gl,float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot) {

        MR=rC.getMR();
        this.gl=gl;
        setVariables();

        //armourPlus=0;
        //handlingPlus=0;
        //luckPlus=0;
        //sizePlus=0;

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

        if (notInitialized){
            length=10f*actualSize;
            height =3f*actualSize;
            width  =3f*actualSize;
            noOfVertices=8*3;
            vertices =new float[noOfVertices];
            //	vertices={0f,0f,0f,width,0f,0f,width,height,0f,0f,height,0f,0f,0f,length,width,0f,length,width,height,length,0f, height,length};


            for (int c=0;c<8;c++){
                vertices[c*3+0]= model[c*3+0]*width;
                vertices[c*3+1]= model[c*3+1]*height;
                vertices[c*3+2]= model[c*3+2]*length;
            }

            //for (int c=0;c<8;c++){
            //    model[c*3+0]=vertices[c*3+0];
            //    model[c*3+1]=vertices[c*3+1];
            //    model[c*3+2]=vertices[c*3+2];
            //}

            ///	for (int c=0;c<8;c++){
            //	vertices[c*3+0]=width*(float)(c%2);
            //	vertices[c*3+1]=height*(float)((Math.ceil((double)(c)/2d)%2));
            //	vertices[c*3+2]=length*(float)((Math.ceil((double)(c)/4d)%2));
            //}

            notInitialized=false;
        }

        setModelVertArray(new float[vertices.length]);
        for (int c=0;c< getModelVertArray().length;c++) {
            getModelVertArray()[c]=vertices[c];
        }
        setModelColorArray(new float[colors.length]);
        for (int c=0;c< getModelColorArray().length;c++) {
            getModelColorArray()[c]=colors[c];
        }
        setModelIndArray(new short[indices.length]);
        for (int c=0;c< getModelIndArray().length;c++) {
            getModelIndArray()[c]=indices[c];
        }

        //Render(xpos, ypos, zpos, this.xrot, this.yrot, this.zrot);

    }

    public void redoInitialisation(){
        actualSize     =calculateSize();
        length  =10*actualSize;
        width   =3*actualSize;
        height  =3*actualSize;
        noOfVertices=8*3;
        vertices =new float[noOfVertices];
        //	vertices={0f,0f,0f,width,0f,0f,width,height,0f,0f,height,0f,0f,0f,length,width,0f,length,width,height,length,0f, height,length};


        for (int c=0;c<8;c++){
            vertices[c*3+0]= model[c*3+0]*width;
            vertices[c*3+1]= model[c*3+1]*height;
            vertices[c*3+2]= model[c*3+2]*length;
        }



        ///	for (int c=0;c<8;c++){
        //	vertices[c*3+0]=width*(float)(c%2);
        //	vertices[c*3+1]=height*(float)((Math.ceil((double)(c)/2d)%2));
        //	vertices[c*3+2]=length*(float)((Math.ceil((double)(c)/4d)%2));
        //}

        notInitialized=false;


    setModelVertArray(new float[vertices.length]);
    for (int c=0;c< getModelVertArray().length;c++) {
        getModelVertArray()[c]=vertices[c];
    }
    setModelColorArray(new float[colors.length]);
    for (int c=0;c< getModelColorArray().length;c++) {
        getModelColorArray()[c]=colors[c];
    }
    setModelIndArray(new short[indices.length]);
    for (int c=0;c< getModelIndArray().length;c++) {
        getModelIndArray()[c]=indices[c];
    }

}

    public void Render(float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot){

        redoInitialisation();
        MR=rC.getMR();
        this.xpos=MotorX;
        this.ypos=MotorY;
        this.zpos=MotorZ;
     /*   actualSize      =size -sizePlus*0.03f;
        length  =10*actualSize;
        width   =3*actualSize;
        height  =3*actualSize;


        this.xrot=xrot;
        this.yrot=yrot;
        this.zrot=zrot;
       */
        gl.glPushMatrix();
        {

            //gl.glRotatef(xrot      ,xpos+2/2*width+1  ,ypos+1/2*height    ,zpos+1/2*length  );
            //gl.glRotatef(yrot      ,xpos+2/2*width    ,ypos+1/2*height+1  ,zpos+1/2*length  );
            //gl.glRotatef(zrot       ,xpos+2/2*width    ,ypos+1/2*height    ,zpos+1/2*length+1);

            gl.glTranslatef(xpos,ypos,zpos	);
            gl.glRotatef(xrot, 0,1,0);
            gl.glRotatef(yrot, 1,0,0);
            gl.glRotatef(zrot, 0,0,1);


                rC.drawWithBuffers(gl,true,MR.getmVehicleVerts(),MR.getmVehicleColor(),MR.getmVehicleInd(),36);

        }

        gl.glPopMatrix();
    }

    public void makeEverything(){
        modelVertArray=getModelVertArray();
        modelColorArray=getModelColorArray();
        modelIndArray=getModelIndArray();

        setSecondRingVertsArray(getModel2());
        setSecondRingColorArray(getModelColor2());
        setSecondRingIndArray(getModelIndices2());


    }

    public float[] getVertsCollide(){return vertices;}

    public float[] getModel() {
        return model;
    }

    public void setModel(float[] model) {
        this.model = model;
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
