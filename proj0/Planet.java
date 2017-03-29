import java.lang.*;
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

  public Planet(double xP, double yP, double xV, double yV, double m, String img){
    xxPos=xP;
    yyPos=yP;
    xxVel=xV;
    yyVel=yV;
    mass=m;
    imgFileName=img;
  }

  public Planet(Planet p){
    xxPos=p.xxPos;
    yyPos=p.yyPos;
    xxVel=p.xxVel;
    yyVel=p.yyVel;
    mass=p.mass;
    imgFileName=p.imgFileName;
  }

  public double calcDistance(Planet p){
    double dx=p.xxPos-this.xxPos;
    double dy=p.yyPos-this.yyPos;
    double r=Math.sqrt(dx*dx+dy*dy);
    return r;
  }

  public double calcForceExertedBy(Planet p){
    double G=6.67*Math.pow(10,-11);
    double r=this.calcDistance(p);
    double F=G*this.mass*p.mass/(r*r);
    return F;
  }

  public double calcForceExertedByX(Planet p){
    double r=this.calcDistance(p);
    double F=calcForceExertedBy(p);
    double dx=p.xxPos-this.xxPos;
    double Fx=F*dx/r;
    return Fx;

  }

  public double calcForceExertedByY(Planet p){
    double r=this.calcDistance(p);
    double F=calcForceExertedBy(p);
    double dy=p.yyPos-this.yyPos;
    double Fy=F*dy/r;
    return Fy;
  }

  public double calcNetForceExertedByX(Planet[] allPlanets){
    double netX=0;
    for(int i=0;i<allPlanets.length;i++){
      if(!this.equals(allPlanets[i])){
        netX+=this.calcForceExertedByX(allPlanets[i]);
      }
    }
    return netX;
  }

  public double calcNetForceExertedByY(Planet[] allPlanets){
    double netY=0;
    for(int i=0;i<allPlanets.length;i++){
      if(!this.equals(allPlanets[i])){
        netY+=this.calcForceExertedByY(allPlanets[i]);
      }
    }
    return netY;
  }

  /**
   * update the planet's position and velocity instance variables
   */
  public void update(double dt, double fX, double fY){
    double accX=fX/this.mass;
    double accY=fY/this.mass;
    this.xxVel=this.xxVel+dt*accX;
    this.yyVel=this.yyVel+dt*accY;
    this.xxPos=this.xxPos+this.xxVel*dt;
    this.yyPos=this.yyPos+this.yyVel*dt;
  }

  /**
   *draw itself at its appropriate position
   */
   public void draw(){
    // double radius=NBody.readRadius("./data/planets.txt");
     //StdDraw.setScale(-1*radius, radius);
     /* Clears the drawing window. */
 		// StdDraw.clear();


 		 StdDraw.picture(xxPos, yyPos, "./images/"+imgFileName);
   }
}
