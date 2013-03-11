package dk.dma.enav.model.voyage;

public class RouteLeg {

    /** Speed in knots. */
    private Double speed;

    /** Port XTD. */
    private Double xtdPort;

    /** Starboard XTD. */
    private Double xtdStarboard;

    /** Safe Haven Width */
    private double SFWidth;
    
    /** Safe Haven Length */
    private double SFLen;
    
    public RouteLeg(){
        
    }

    public double getSFLen() {
        return SFLen;
    }

    public double getSFWidth() {
        return SFWidth;
    }

    public Double getSpeed() {
        return speed;
    }

    public Double getXtdPort() {
        return xtdPort;
    }

    public Double getXtdStarboard() {
        return xtdStarboard;
    }

    public void setSFLen(double sFLen) {
        SFLen = sFLen;
    }

    public void setSFWidth(double sFWidth) {
        SFWidth = sFWidth;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public void setXtdPort(Double xtdPort) {
        this.xtdPort = xtdPort;
    }

    public void setXtdStarboard(Double xtdStarboard) {
        this.xtdStarboard = xtdStarboard;
    }
    
    
    
}
