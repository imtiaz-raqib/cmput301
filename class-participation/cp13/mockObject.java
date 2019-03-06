class PersonTracker {
    ...
    Location lastLocation = null;

    // called every second
    void updateLocation( Location l ) throws GPSException {
        if (lastLocation != null) {
            if (lastLocation.distance( l ) > 200.0*1000/3600) {
                // 200 km/h in m/s
                GPS.getGPS().disable( 200 );
                throw new GPSException( "Too Fast!" );
            }
        }
        lastLocation = l;
    }
}

interface Location {
    // distance in metres
    public double distance( Location l );
}

class TestPersonTracker extends TestCase {
    void testTooFast() {
        PersonTracker p = new PersonTracker();
        Location l = new MockLocation( 0, 0 );
        try {
            p.updateLocation( l );
            p.updateLocation( l );
            fail( "This was supposed to throw exception." );
        } catch (GPSException e) {
            return; // exception was properly thrown
        }
    }
}

/*
As seen from line 16, MockLocation implements Location interface
*/
class MockLocation implements Location {

    int param1;
    int param2;

    public void MockLocation(int a, int b) {
        this.param1 = a;
        this.param2 = b;
    }
    /*
    Should return a number greater than 200.0*1000/3600 to throw an exception
    */
    public double distance(Location A) {
        return 300.0*1000/3600;
    }

}