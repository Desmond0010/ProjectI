package com.leaflea.johndoran.projecti;


import javax.microedition.khronos.opengles.GL10;

public class Collisions {
    public Collisions(){
        collided=false;
    }

    public float getExtendedAttraction() {
        return extendedAttraction;
    }


    public void setExtendedAttraction(float extendedAttraction) {
        this.extendedAttraction = extendedAttraction;
    }


    private Boolean collided;
    private static int counter1;

    private  int counter2;
    private  int counter3;
    private  int counter4;
    private  float L;
    private  float W;
    private  float H;
    //public Collisions() {}
/*public  void ShipCol(BallOfDeath BOD,Enemies vehicle){

		//the cube`s vertices

		float[] vecCoords2=new float[24];
		float[] rocketCoords=new float[12];
		counter1=0;
		counter2=0;
		counter3=0;
		counter4=0;
		for (counter1=0;counter1<2;counter1++)
		{

			if (counter1==0){
				L=0;
			}else{
				L=vehicle.getLength();
			}
			for (counter2=0;counter2<2;counter2++)
			{
				if (counter1==0){
					W=0;
				}else{

					W=vehicle.getWidth();
				}

				for (counter3=0;counter3<2;counter3++)
				{
					if (counter1==0){
						H=0;
					}else{
						H=vehicle.getHeight();
					}
					vecCoords2[counter1*12+counter2*6+counter3*3+0]=L + vehicle.getX();
					vecCoords2[counter1*12+counter2*6+counter3*3+1]=W + vehicle.getY();
					vecCoords2[counter1*12+counter2*6+counter3*3+2]=H + vehicle.getZ();
					//System.out.println(vecCoords2[counter1*12+counter2*6+counter3*3+0]+"  "+vecCoords2[counter1*12+counter2*6+counter3*3+1]+"  "+vecCoords2[counter1*12+counter2*6+counter3*3+2]+"  ");
				}}}

		for (counter1=0;counter1<1;counter1++){
			rocketCoords[counter1*3+0]=BOD.getX();
		    rocketCoords[counter1*3+1]=BOD.getY();
		    rocketCoords[counter1*3+2]=BOD.getZ()+BOD.radius*BOD.size;

		}

		//max distance from each other should be length of radius

		for (counter1=0;counter1<8;counter1++){
			for (counter2=0;counter2<1;counter2++){
				float thing=getDistance(vecCoords2[counter1*3],vecCoords2[counter1*3+1],vecCoords2[counter1*3+2],rocketCoords[counter2*3+0],rocketCoords[counter2*3+1],rocketCoords[counter2*3+2]);
				if(thing<BOD.radius){
					System.out.println("DEAD : Ball of Death");
					Main.Reset();
				}else{//	System.out.println("Alive  "+thing);
				}}}
		}

	*/

    public  Boolean ShipCol(BallOfDeath BOD,Vehicles vehicle){

        //the cube`s vertices
        collided=false;
        float[] vecCoords2=new float[24];
        float[] rocketCoords=new float[12];
        counter1=0;
        counter2=0;
        counter3=0;
        counter4=0;
        for (counter1=0;counter1<2;counter1++)
        {

            if (counter1==0){
                L=0;
            }else{
                L=vehicle.getLength();
            }
            for (counter2=0;counter2<2;counter2++)
            {
                if (counter1==0){
                    W=0;
                }else{

                    W=vehicle.getWidth();
                }

                for (counter3=0;counter3<2;counter3++)
                {
                    if (counter1==0){
                        H=0;
                    }else{
                        H=vehicle.getHeight();
                    }
                    vecCoords2[counter1*12+counter2*6+counter3*3+0]=L + vehicle.getXpos();
                    vecCoords2[counter1*12+counter2*6+counter3*3+1]=W + vehicle.getYpos();
                    vecCoords2[counter1*12+counter2*6+counter3*3+2]=H + vehicle.getZpos();

                }}}

        for (counter1=0;counter1<1;counter1++){
            rocketCoords[counter1*3+0]=BOD.getX();
            rocketCoords[counter1*3+1]=BOD.getY();
            rocketCoords[counter1*3+2]=BOD.getZ();

        }

        //max distance from each other should be length of radius

        for (counter1=0;counter1<8;counter1++){
            for (counter2=0;counter2<1;counter2++){
                float thing=getDistance(vecCoords2[counter1*3],vecCoords2[counter1*3+1],vecCoords2[counter1*3+2],rocketCoords[counter2*3+0],rocketCoords[counter2*3+1],rocketCoords[counter2*3+2]);
                if(thing< BOD.getRadius()){
                    System.out.println("HIT : Ball of Death");
                    collided=true;
                }else{//	System.out.println("Alive  "+thing);
                    collided =false;
                }}}
        return collided;
    }


    public  Boolean ShipCol(Rocket rocket,Vehicles vehicle){

        //the cube`s vertices

        collided=false;
        float[] vecCoords2=new float[24];
        float[] rocketCoords=new float[12];
        counter1=0;
        counter2=0;
        counter3=0;
        counter4=0;
        for (counter1=0;counter1<2;counter1++)
        {

            if (counter1==0){
                L=0;
            }else{
                L=vehicle.getLength();
            }
            for (counter2=0;counter2<2;counter2++)
            {
                if (counter1==0){
                    W=0;
                }else{

                    W=vehicle.getWidth();
                }

                for (counter3=0;counter3<2;counter3++)
                {
                    if (counter1==0){
                        H=0;
                    }else{
                        H=vehicle.getHeight();
                    }
                    vecCoords2[counter1*12+counter2*6+counter3*3+0]=L + vehicle.getXpos();
                    vecCoords2[counter1*12+counter2*6+counter3*3+1]=W + vehicle.getYpos();
                    vecCoords2[counter1*12+counter2*6+counter3*3+2]=H + vehicle.getZpos();
                    //System.out.println(vecCoords2[counter1*12+counter2*6+counter3*3+0]+"  "+vecCoords2[counter1*12+counter2*6+counter3*3+1]+"  "+vecCoords2[counter1*12+counter2*6+counter3*3+2]+"  ");
                }}}

        for (counter1=0;counter1<4;counter1++){
            rocketCoords[counter1*3+0]=rocket.getX();
            rocketCoords[counter1*3+1]=rocket.getY();
            rocketCoords[counter1*3+2]=rocket.getZ()+rocket.ConeLength+counter1/4*rocket.CylLength;

        }

        //max distance from each other should be length of radius

        for (counter1=0;counter1<8;counter1++){
            for (counter2=0;counter2<4;counter2++){
                float thing=getDistance(vecCoords2[counter1*3],vecCoords2[counter1*3+1],vecCoords2[counter1*3+2],rocketCoords[counter2*3+0],rocketCoords[counter2*3+1],rocketCoords[counter2*3+2]);


                if(thing<rocket.radius){
                    System.out.println("DEAD");

                    collided = true;


                }else{
                    collided=false;
                    //	System.out.println("Alive  "+thing);

                }}}
        return collided;



    }


    //	public Rocket Rocket =new Rocket();
    public Vehicles Vehicle;
    public Rock Cuboids;////////////////////////////////////////////////////////////////////

    /*
    public void CollidePoints(The_Cube Vehicles, Meteor met){
        collided=false;
        float[][][][] veccoords=new float[2][2][2][3];
        for (int xyz=0;xyz<3;xyz++){
            int nox=1;
            int noy=1;
            int noz=1;
            float metcoords[][][][]=new float[nox][noy][noz][3];

            for(int xon=0;xon<2;xon++){

                for(int yon=0;yon<2;yon++){

                    for(int zon=0;zon<2;zon++){
                        veccoords[xon][yon][zon][0]=((float)xon)*(Vehicles.width)+Vehicles.xpos;
                        veccoords[xon][yon][zon][1]=((float)yon)*(Vehicles.height)+Vehicles.ypos;
                        veccoords[xon][yon][zon][2]=((float)zon)*(Vehicles.length)+Vehicles.zpos;

                    }

                }

            }

            metcoords=met.VerticesOfMeteor;




        }
    }*/


    public Boolean CollideCuboid(The_Cube Vehicles, Rock Cuboidss){
        collided=false;
        Vehicle=Vehicles;
        Cuboids=Cuboidss;
        float vx=Vehicle.getXpos();
        float vy=Vehicle.getYpos();
        float vz=Vehicle.getZpos();
        float vw=Vehicle.getWidth();
        float vh=Vehicle.getHeight();
        float vl=Vehicle.getLength();


        Main ma=new Main();
        float L;
        float W;
        float H;
        float X;
        float Y;
        float Z;
        X=Cuboids.getX();
        Y=Cuboids.getY();
        Z=Cuboids.getZ();

        int noc=Cuboids.getno(); // number of cuboids

        for (counter1=0;counter1<noc;counter1++){
            L=Cuboids.getLength(counter1);
            W=Cuboids.getWidth(counter1);
            H=Cuboids.getHeight(counter1);
            //System.out.println(vz+"  "+W +"  "+H+"   "+L);


            //	if ((((vx<X)&&(X<(vx+vw))) || ((vx<(X+W))&&((X+W)<(vx+vw))))){
            //System.out.print ("x : true  "+counter+" " );

            //	}else{
            //System.out.print ("x : false  " +counter+" ");
            //	}
            //	if		(((vy<Y)&&(Y<(vy+vh))) || ((vy<(Y+H))&&((Y+H)<(vy+vh)))){
            //System.out.print ("y : true  ");
            //	} else{
            //System.out.print ("y : false  ");
            //	}
            //if		(((vz<Z)&&(Z<(vz+vl))) || ((vz<(Z+L))&&((Z+L)<(vz+vl)))){
            //System.out.println ("z : true  " );
            //}  else{
            //		//System.out.println ("z : false   ");
            //}

            if ((((vx<X)&&(X<(vx+vw))) || ((vx<(X+W))&&((X+W)<(vx+vw))))   &&
                    (((vy<Y)&&(Y<(vy+vh))) || ((vy<(Y+H))&&((Y+H)<(vy+vh))))   &&
                    (((vz<Z)&&(Z<(vz+vl))) || ((vz<(Z+L))&&((Z+L)<(vz+vl)))))
            {
                //collision true

                System.out.println("DEAD");
                collided= true;


                //if(((vx<X)&&(X>(vx+vw))) ){}
                //if ((vx<(X+W))&&((X+W)>(vx+vw))){}


            }else{


            }

        }
        return collided;

    }
    //private Main ma=new Main();

    public Boolean CollideForGold(The_Cube Vehicles, Gold gold_object){
        collided=false;
        Vehicle=Vehicles;
        float extendedAttration=1f;

        extendedAttraction=1f+Vehicles.getSizePlus()*0.2f;
        float vx=Vehicle.getXpos()-1f;
        float vy=Vehicle.getYpos()-1f;
        float vz=Vehicle.getZpos()-1f;
        float vw=Vehicle.getWidth()+1f;
        float vh=Vehicle.getHeight()+1f;
        float vl=Vehicle.getLength()+1f;


        //Main ma=new Main();

        float L;
        float W;
        float H;
        float X;
        float Y;
        float Z;
        X=gold_object.getX()-extendedAttration;
        Y=gold_object.getY()-extendedAttration;
        Z=gold_object.getZ()-extendedAttration;

        // number of cuboids

        if (gold_object.value==1){
            L=gold_object.getLength()+extendedAttration;
            W=gold_object.getWidth()+extendedAttration;
            H=gold_object.getHeight()+extendedAttration;
        }
        else if (gold_object.value==2){
            L=gold_object.getLength()*2f+extendedAttration;
            W=gold_object.getWidth()+extendedAttration;
            H=gold_object.getHeight()+extendedAttration;
        }
        else if (gold_object.value==3){
            L=gold_object.getDIAMONDlength()+extendedAttration;
            W=gold_object.getDIAMONDwidth()+extendedAttration;
            H=gold_object.getDIAMONDheight()+extendedAttration;
        }
        else{
            L=gold_object.getLength()+extendedAttration;
            W=gold_object.getWidth()+extendedAttration;
            H=gold_object.getHeight()+extendedAttration;
        }
		/*

		glPushMatrix();
		glTranslatef(vx,vy,vz);
		glColor4f(1,0.3f,0,0.3f);
		glBegin(GL_QUADS);
		{
		 glVertex3f(0 ,0            ,0    );        glVertex3f(vw,0        ,0     );
		 glVertex3f(vw,vh   ,0    );       		    glVertex3f(0    ,vh  ,0     );


		 glVertex3f(0    ,0       ,vl);             glVertex3f(vw, 0       ,vl);
		 glVertex3f(vw,vh  ,vl);                    glVertex3f(0    ,vh   ,vl);


		 glVertex3f(vw,0       ,0     );            glVertex3f(vw, vh,0     );
		 glVertex3f(vw,vh ,vl);                     glVertex3f(vw,0        ,vl);


		 glVertex3f(0    ,0       ,0     );          glVertex3f(0    ,vh   ,0     );
		 glVertex3f(0    ,vh  ,vl);                  glVertex3f(0    ,0        ,vl);


		 glVertex3f(0     ,0  ,0         );          glVertex3f(vw,0        ,0     );
	     glVertex3f(vw    ,0  ,vl	);               glVertex3f(0    ,0        ,vl);


		 glVertex3f(0     ,vh ,0    );               glVertex3f(vw,vh,0     );
		 glVertex3f(vw,vh,vl);                       glVertex3f(0    ,vh,vl);

	}glEnd();

		glPopMatrix();


		glPushMatrix();
		glTranslatef(X,Y,Z);
		glColor4f(1,0,0,0.3f);
		glBegin(GL_QUADS);
		{
		 glVertex3f(0,0            ,0    );          glVertex3f(W,0        ,0     );
		 glVertex3f(W,H   ,0    );          glVertex3f(0    ,H  ,0     );


		 glVertex3f(0    ,0       ,L);          glVertex3f(W, 0       ,L);
		 glVertex3f(W,H  ,L);          glVertex3f(0    ,H   ,L);


		 glVertex3f(W,0       ,0     );          glVertex3f(W, H ,0     );
		 glVertex3f(W,H ,L);          glVertex3f(W,0        ,L);


		 glVertex3f(0    ,0       ,0     );          glVertex3f(0    ,H   ,0     );
		 glVertex3f(0    ,H  ,L);          glVertex3f(0    ,0        ,L);


		 glVertex3f(0     ,0  ,0         );          glVertex3f(W,0        ,0     );
	     glVertex3f(W    ,0  ,L	);          glVertex3f(0    ,0        ,L);


		 glVertex3f(0     ,H ,0    );          glVertex3f(W,H,0     );
		 glVertex3f(W,H,L);          glVertex3f(0    ,H,L);

	}glEnd();

		glPopMatrix();

	*/

        //	if ((((vx<X)&&(X<(vx+vw))) || ((vx<(X+W))&&((X+W)<(vx+vw))))){
        //System.out.print ("x : true  "+counter+" " );

        //	}else{
        //System.out.print ("x : false  " +counter+" ");
        //	}
        //	if		(((vy<Y)&&(Y<(vy+vh))) || ((vy<(Y+H))&&((Y+H)<(vy+vh)))){
        //System.out.print ("y : true  ");
        //	} else{
        //System.out.print ("y : false  ");
        //	}
        //if		(((vz<Z)&&(Z<(vz+vl))) || ((vz<(Z+L))&&((Z+L)<(vz+vl)))){
        //System.out.println ("z : true  " );
        //}  else{
        //		//System.out.println ("z : false   ");
        //}

        if ((((vx<X)&&(X<(vx+vw))) || ((vx<(X+W))&&((X+W)<(vx+vw))))   &&
                (((vy<Y)&&(Y<(vy+vh))) || ((vy<(Y+H))&&((Y+H)<(vy+vh))))   &&
                (((vz<Z)&&(Z<(vz+vl))) || ((vz<(Z+L))&&((Z+L)<(vz+vl)))))
        {
            //collision true

            System.out.println("DEAD");
            collided= true;


            //if(((vx<X)&&(X>(vx+vw))) ){}
            //if ((vx<(X+W))&&((X+W)>(vx+vw))){}


        }else{


        }


        return collided;

    }

	/*
	 *
	 * Here I plan to change my emphasis from having the vehicle being  tested as a cube and
	 * to it being tested as vertices.
	 *
	 */


    private float extendedAttraction=0f;
    public Boolean Collide_vertices_gold(Vehicles vehicle,Gold gold_object){
        collided=false;

        //int noOfVertices=vehicle.getNoOfVertices();
        //float vertices[]=vehicle.getVertices();

        float[] vertices=vehicle.getVertsCollide();
        int noOfVertices=vertices.length;
        float vx=vehicle.getXpos();
        float vy=vehicle.getYpos();
        float vz=vehicle.getZpos();


        int value=gold_object.getValue();

        float X=gold_object.getX()+gold_object.getGX()[value-1]-extendedAttraction;
        float Y=gold_object.getY()+gold_object.getGY()[value-1]-extendedAttraction;
        float Z=gold_object.getZ()+gold_object.getGZ()[value-1]-extendedAttraction*2f;

        // number of cuboids

        if (value==1){
            L=gold_object.getGL()[value-1]+extendedAttraction*2f;
            W=gold_object.getGW()[value-1]+extendedAttraction;
            H=gold_object.getGH()[value-1]+extendedAttraction;
        }
        else if (value==2){
            L=gold_object.getGW()[value-1]+extendedAttraction*2f;
            W=gold_object.getGH()[value-1]+extendedAttraction;
            H=gold_object.getGL()[value-1]+extendedAttraction;
        }
        else if (value==3){
            L=gold_object.getGW()[value-1]+extendedAttraction*2f;
            W=gold_object.getGH()[value-1]+extendedAttraction;
            H=gold_object.getGL()[value-1]+extendedAttraction;
        }
        else{
            L=gold_object.getLength()+extendedAttraction*2f;
            W=gold_object.getWidth() +extendedAttraction;
            H=gold_object.getHeight()+extendedAttraction;
        }
        for (int c=0;c<noOfVertices/3;c++){


            if (          ((X<(vertices[c*3+0]+vx))&&((vertices[c*3+0]+vx)<(X+W)))
                    &&    ((Y<(vertices[c*3+1]+vy))&&((vertices[c*3+1]+vy)<(Y+H)))
                    &&    ((Z<(vertices[c*3+2]+vz))&&((vertices[c*3+2]+vz)<(Z+L)))  ) {
                collided=true;
            }else{
            }
        }

        return collided;



    }
    /*//old GOLD collisions

    private float extendedAttraction=3f;
    public Boolean Collide_vertices_gold(Vehicles vehicle,Gold gold_object){
        collided=false;

        //int noOfVertices=vehicle.getNoOfVertices();
        //float vertices[]=vehicle.getVertices();

        float[] vertices=vehicle.getVertsCollide();
        int noOfVertices=vertices.length;
        float vx=vehicle.getXpos();
        float vy=vehicle.getYpos();
        float vz=vehicle.getZpos();


        extendedAttraction=9f+vehicle.getSizePlus()*0.2f;

        float X=gold_object.getX()-extendedAttraction;
        float Y=gold_object.getY()-extendedAttraction;
        float Z=gold_object.getZ()-extendedAttraction;

        // number of cuboids

        if (gold_object.value==1){
            L=gold_object.getLength()*gold_object.getMultiplier()+extendedAttraction;
            W=gold_object.getWidth() *gold_object.getMultiplier()+extendedAttraction;
            H=gold_object.getHeight()*gold_object.getMultiplier()+extendedAttraction;
        }
        else if (gold_object.value==2){
            L=gold_object.getLength()*2f*gold_object.getMultiplier()+extendedAttraction;
            W=gold_object.getWidth()    *gold_object.getMultiplier()+extendedAttraction;
            H=gold_object.getHeight()   *gold_object.getMultiplier()+extendedAttraction;
        }
        else if (gold_object.value==3){
            L=gold_object.getDIAMONDlength()*gold_object.getMultiplier()+extendedAttraction;
            W=gold_object.getDIAMONDwidth() *gold_object.getMultiplier()+extendedAttraction;
            H=gold_object.getDIAMONDheight()*gold_object.getMultiplier()+extendedAttraction;
        }
        else{
            L=gold_object.getLength()*gold_object.getMultiplier()+extendedAttraction;
            W=gold_object.getWidth() *gold_object.getMultiplier()+extendedAttraction;
            H=gold_object.getHeight()*gold_object.getMultiplier()+extendedAttraction;
        }
        for (int c=0;c<noOfVertices/3;c++){


            if (          ((X<(vertices[c*3+0]+vx))&&((vertices[c*3+0]+vx)<(X+W)))
                    &&    ((Y<(vertices[c*3+1]+vy))&&((vertices[c*3+1]+vy)<(Y+H)))
                    &&    ((Z<(vertices[c*3+2]+vz))&&((vertices[c*3+2]+vz)<(Z+L)))  ) {
                collided=true;
            }else{
            }
        }

        return collided;



    }

     */

    public Boolean Collide_vertices_power(Vehicles vehicle,PowerUps gold_object){
        collided=false;
        //int noOfVertices=vehicle.getNoOfVertices();
        //float vertices[]=vehicle.getVertices();


        /*
        float[] vertices;
        if (vehicle.getID_NUMBER()==2){
            vertices=vehicle.getVertices();

        }else {
            vertices = vehicle.getModelVertArray();
        }
        int noOfVertices=vertices.length;
         */

        float[] vertices=vehicle.getVertsCollide();
        int noOfVertices=vertices.length;

        float vx=vehicle.getXpos();
        float vy=vehicle.getYpos();
        float vz=vehicle.getZpos();


        extendedAttraction=6f+vehicle.getSizePlus()*0.5f;

        float X=gold_object.getX()-extendedAttraction;
        float Y=gold_object.getY()-extendedAttraction;
        float Z=gold_object.getZ()-extendedAttraction*2f;

        // number of cuboids

        if (gold_object.getValue()==1){
            L=gold_object.getLength()+extendedAttraction*2f;
            W=gold_object.getWidth()+extendedAttraction;
            H=gold_object.getHeight()+extendedAttraction;
        }
        else if (gold_object.getValue()==2){
            L=gold_object.getLength()*2f+extendedAttraction*2f;
            W=gold_object.getWidth()+extendedAttraction;
            H=gold_object.getHeight()+extendedAttraction;
        }
        else if (gold_object.getValue()==3){
            L=gold_object.getDIAMONDlength()*gold_object.getLength()+extendedAttraction*2f;
            W=gold_object.getDIAMONDwidth() *gold_object.getWidth() +extendedAttraction;
            H=gold_object.getDIAMONDheight()*gold_object.getHeight()+extendedAttraction;
        }
        else{
            L=gold_object.getLength()+extendedAttraction*2f;
            W=gold_object.getWidth()+extendedAttraction;
            H=gold_object.getHeight()+extendedAttraction;
        }

        for (int c=0;c<noOfVertices/3;c++){



            if (  (        ((X<(vertices[c*3+0]+vx))&&((vertices[c*3+0]+vx)<(X+W)))
                    &&    ((Y<(vertices[c*3+1]+vy))&&((vertices[c*3+1]+vy)<(Y+H)))
                    &&    ((Z<(vertices[c*3+2]+vz))&&((vertices[c*3+2]+vz)<(Z+L))) ) ) {
                collided=true;
                if (collided){
                    return true;
                }
            }else{
            }
        }

        return collided;



    }
	/*
	public Boolean Collide_vertices_gold(Vehicles vehicle,PowerUps gold_object){
		collided=false;
		int noOfVertices=vehicle.getNoOfVertices();
		float vertices[]=vehicle.getVertices();
		float vx=vehicle.getXpos();
		float vy=vehicle.getYpos();
		float vz=vehicle.getZpos();


		float extendedAttraction=3f;

		float X=gold_object.getX()-extendedAttraction;
		float Y=gold_object.getY()-extendedAttraction;
		float Z=gold_object.getZ()-extendedAttraction;

		 // number of cuboids

		if (gold_object.value==1){
		L=gold_object.getLength()+extendedAttraction;
		W=gold_object.getWidth()+extendedAttraction;
		H=gold_object.getHeight()+extendedAttraction;
		}
		else if (gold_object.value==2){
			L=gold_object.getLength()*2f+extendedAttraction;
			W=gold_object.getWidth()+extendedAttraction;
			H=gold_object.getHeight()+extendedAttraction;
			}
		else if (gold_object.value==3){
			L=gold_object.getDIAMONDlength()+extendedAttraction;
			W=gold_object.getDIAMONDwidth()+extendedAttraction;
			H=gold_object.getDIAMONDheight()+extendedAttraction;
			}
		else{
			L=gold_object.getLength()+extendedAttraction;
			W=gold_object.getWidth()+extendedAttraction;
			H=gold_object.getHeight()+extendedAttraction;
		}
		//System.out.println(vx+"  "+vy+"  "+vz)	;
		for (int c=0;c<noOfVertices/3;c++){


		if (          ((X<(vertices[c*3+0]+vx))&&((vertices[c*3+0]+vx)<(X+W)))
				&&    ((Y<(vertices[c*3+1]+vy))&&((vertices[c*3+1]+vy)<(Y+H)))
				&&    ((Z<(vertices[c*3+2]+vz))&&((vertices[c*3+2]+vz)<(Z+L)))  ) {
		System.out.println("Collided")	;
		collided=true;
		}else{
		//	System.out.println("notCollided")	;
		}
		}
		return collided;

	}

	*/




    public Boolean Collide_vertices_cuboid(Vehicles vehicle, float X,float Y,float Z,float W,float H,float L){
        collided=false;
        int noOfVertices=vehicle.getNoOfVertices();
        float vertices[]=vehicle.getVertices();
        float vx=vehicle.getXpos();
        float vy=vehicle.getYpos();
        float vz=vehicle.getZpos();


        //System.out.println(vx+"  "+vy+"  "+vz)	;
        for (int c=0;c<noOfVertices/3;c++){

			/*
		if (       (X<(vertices[c*3+0]+vx)&&((vertices[c*3+0]+vx)<(X+W))) ){
			System.out.println("Collidedx")	;
		}
		if (       (X<(vertices[c*3+0]+vx)&&((vertices[c*3+0]+vx)<(X+W))) ){
			System.out.println("Collidedy")	;
		}
		if (       (X<(vertices[c*3+0]+vx)&&((vertices[c*3+0]+vx)<(X+W))) ){
			System.out.println("Collidedz")	;
		}
				*/
            if (          ((X<(vertices[c*3+0]+vx))&&((vertices[c*3+0]+vx)<(X+W)))
                    &&    ((Y<(vertices[c*3+1]+vy))&&((vertices[c*3+1]+vy)<(Y+H)))
                    &&    ((Z<(vertices[c*3+2]+vz))&&((vertices[c*3+2]+vz)<(Z+L)))  ) {
                System.out.println("Collided-0")	;
                collided=true;
            }else{
                //	System.out.println("notCollided")	;
            }


        }

        return collided;



    }
    static renderController rC=new renderController();
    static MyRenderer MR;
    public Boolean Collide_vertices_cube(Vehicles vehicle,Rock rock,GL10 gl){
        this.MR=rC.getMR();

        collided=false;
        float[] vertices=vehicle.getVertsCollide();
        int noOfVertices=vertices.length;

        float vx=vehicle.getXpos();
        float vy=vehicle.getYpos();
        float vz=vehicle.getZpos();
        /*int noOfVertices=vehicle.getNoOfVertices();
        float vertices[]=vehicle.getVertices();
        float vx=vehicle.getXpos();
        float vy=vehicle.getYpos();
        float vz=vehicle.getZpos();*/

        float X=rock.getX();
        float Y=rock.getY();
        float Z=rock.getZ();
        float W=rock.getWidth (0);
        float H=rock.getHeight(0);
        float L=rock.getLength(0);
        //System.out.println(vx+"  "+vy+"  "+vz)	;

        /*gl.glPushMatrix();
        gl.glTranslatef(X, Y, Z);
        gl.glColor4f(1, 1, 1, 1f);

            //rC.drawWithBuffers(gl,true,MR.getmStandardCuboidVerts(),MR.getmStandardCuboidColor(),MR.getmStandardCuboidInd(),24);
            rC.drawWithBuffers(gl,MR.getmStandardCuboidVerts(),MR.getmStandardCuboidInd(),24);

        gl.glPopMatrix();*/

        for (int c=0;c<vertices.length/3;c++){


            if (            (((X)<=(vertices[c*3+0]+vx))&&((vertices[c*3+0]+vx)<=(X+W)))
                    &&      (((Y)<=(vertices[c*3+1]+vy))&&((vertices[c*3+1]+vy)<=(Y+H)))
                    &&      (((Z)<=(vertices[c*3+2]+vz))&&((vertices[c*3+2]+vz)<=(Z+L)))
                    ) {
                collided=true;

                return collided;

            }else{
            }
        }

        return collided;



    }


    public Boolean collide_vertices_rocket(Vehicles vehicle,Rocket rocket){

        collided=false;
        float[] vertices=vehicle.getVertsCollide();
        int noOfVertices=vertices.length;

        float vx=vehicle.getXpos();
        float vy=vehicle.getYpos();
        float vz=vehicle.getZpos();



        float X=rocket.getX();
        float Y=rocket.getY();
        float Z=rocket.getZ();
        float radius=rocket.getRadius() ;
        float ConeLength=rocket.getConeLength();
        float CylLength=rocket.getCylLength();
        float[] RocketVertices=new float[9];

        for (int b=0;b<3;b++){

            RocketVertices[b*3+0]=X;
            RocketVertices[b*3+1]=Y;
            RocketVertices[b*3+2]=Z+ConeLength+CylLength*(b+1)/5;


            for (int c=0;c<noOfVertices/3;c++){
                if (getDistance(vertices[c*3+0]+vx,vertices[c*3+1]+vy,vertices[c*3+2]+vz,RocketVertices[b*3+0],RocketVertices[b*3+1],RocketVertices[b*3+2])<radius){

                    collided=true;

                }
                if (collided==true){
                    return collided;
                }
            }

        }




        return collided;


    }

    public Boolean collide_vertices_BOD(Vehicles vehicle,BallOfDeath BOD){

        collided=false;
        float[] vertices=vehicle.getVertsCollide();
        int noOfVertices=vertices.length;

        float vx=vehicle.getXpos();
        float vy=vehicle.getYpos();
        float vz=vehicle.getZpos();



        float X		=BOD.getX();
        float Y		=BOD.getY();
        float Z		=BOD.getZ();
        float radius=BOD.getRadius() ;

        float[] RocketVertices=new float[3];

        for (int b=0;b<1;b++){

            RocketVertices[b*3+0]=X;
            RocketVertices[b*3+1]=Y;
            RocketVertices[b*3+2]=Z;


            for (int c=0;c<noOfVertices/3;c++){
                if (getDistance(vertices[c*3+0]+vx,vertices[c*3+1]+vy,vertices[c*3+2]+vz,RocketVertices[b*3+0],RocketVertices[b*3+1],RocketVertices[b*3+2])<radius){

                    collided=true;

                }
                if (collided==true){
                    return collided;
                }
            }
        }


        return collided;
    }
    public static float getDistance(float originalX,float originalY, float originalZ, float secondX, float secondY, float secondZ)
    {
        //float magnitude=(float)Math.sqrt( (Math.sqrt((double)((originalX-secondX)*(originalX-secondX)+(originalY-secondY)*(originalY-secondY)))+(originalZ-secondZ)*(originalZ-secondZ)));
        float magnitude=(float)Math.sqrt( (double)((originalX-secondX)*(originalX-secondX)+(originalY-secondY)*(originalY-secondY)+(originalZ-secondZ)*(originalZ-secondZ)));

        return magnitude;

    }


}
