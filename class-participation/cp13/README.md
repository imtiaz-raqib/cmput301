# Class Participation Exercise 13

You want a GPS device to disable itself temporarily if it detects it is going faster than 200 km/h. Write the code for a mock object (class MockLocation) that will allow running of lines 8 and 9 of class PersonTracker in method testTooFast of class TestPersonTracker.

``` java
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
```

State any assumptions. You should try to avoid modifying the given code.
