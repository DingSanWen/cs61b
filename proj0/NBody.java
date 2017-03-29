/**
 *simulate a universe specified in one of the data files
 */
public class NBody {
  /**
    * Given a file name,return a double corresponding
    * to the radius of the universe in that file
    */
  public static double readRadius(String fName){
    In in = new In(fName);
    double radius=in.readDouble();
    radius=in.readDouble();
    return radius;
  }

 /**return an array of Planets corresponding to the planets in the file
  */
  public static Planet[] readPlanets(String fName){
    In in=new In(fName);
    int num=in.readInt();
    double radius=in.readDouble();
    Planet[] planets= new Planet[num];
    for(int i=0;i<num;i++){
      double xxPos=in.readDouble();
      double yyPos=in.readDouble();
      double xxVel=in.readDouble();
      double yyVel=in.readDouble();
      double mass=in.readDouble();
      String imgFileName=in.readString();

      planets[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);

    }

    return planets;
  }

  public static void main(String[] args){
    double T=Double.parseDouble(args[0]);
    double dt=Double.parseDouble(args[1]);
    String fileName=args[2];

    /* creat planets from file*/
    Planet[] planets=readPlanets(fileName);
    String imageToDraw="./images/starfield.jpg";
    double radius=NBody.readRadius(fileName);
    StdDraw.setScale(-1*radius, radius);

		/* Clears the drawing window. */
		StdDraw.clear();

		/* Stamps three copies of advice.png in a triangular pattern. */
		StdDraw.picture(0, 0, imageToDraw);
    /*draws all the planets*/
    for(Planet p : planets){
      p.draw();
    }

    /* play an audio*/
    //StdAudio.loop("./audio/2001.mid")

    for(int time=0;time<T;time+=dt){
      /*Calculate the net x and y forces for each planet,
       *storing these in the xForces and yForces arrays respectively.*/
      double[] xForces =new double[planets.length];
      double[] yForces =new double[planets.length];
      for(int index=0;index<planets.length;index++){
        xForces[index]=planets[index].calcNetForceExertedByX(planets);
        yForces[index]=planets[index].calcNetForceExertedByY(planets);

      }
      /*after the calculation ,update each planet's position, velocity, and acceleration.*/
      for(int index=0;index<planets.length;index++){
        planets[index].update(dt,xForces[index],yForces[index]);
      }

      /*draw it again*/
      StdDraw.clear();
      StdDraw.picture(0, 0, imageToDraw);
      for(Planet p : planets){
        p.draw();
      }
      StdDraw.show(10);
    }

    /*print out the final state of the universe*/
    /*StdOut.printf("%d\n", planets.length);
    StdOut.printf("%.2e\n", radius);
    for (int i = 0; i < planets.length; i++) {
    	StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
       		planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
    }*/
  }
}
