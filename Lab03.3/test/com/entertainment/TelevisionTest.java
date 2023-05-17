package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    //business objects under test
    private Television tv;
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() {
        tv = new Television();
        tv1 = new Television("Sony", 50, DisplayType.OLED);
        tv2 = new Television("Sony", 50, DisplayType.OLED);
    }

    //setVolume method tests////////////////////////////////////////

    @Test
    public void serVolume_showThrowIllegalArgumentException_whenInvalid_upperBound() {
        try {
            tv.setVolume(101);
            fail("Should have thrown IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Invalid volume volume: 101. Allowed range: [0,100].", e.getMessage());

        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentsException_whenInvalid_lowerBound(){
        tv.setVolume(-1);
    }

    @Test
    public void setVolume_shouldStoreVolume_whenValid_upperBound() {
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }
    @Test
    public void setVolume_shouldStoreVolume_whenValid_lowerBound() {
        tv.setVolume(0);
        assertEquals(0,tv.getVolume());
    }

    //changeChannel method tests////////////////////////////////////////

    @Test
    public void changeChannel_shouldStoreChannel_whenValid_lowerBound ()
            throws InvalidChannelException {
        tv.changeChannel(1);
        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreChannel_whenValid_upperBound()
            throws InvalidChannelException {
        tv.changeChannel(999);
        assertEquals(999, tv.getCurrentChannel());
    }

    @Test (expected = InvalidChannelException.class)
    public void changeChannel_shouldStoreChannel_whenInvalid_lowerBound()
            throws InvalidChannelException {
        tv.changeChannel(0);
    }

    @Test (expected = InvalidChannelException.class)
    public void changeChannel_shouldStoreChannel_whenInvalid_upperBound()
    throws InvalidChannelException {
        tv.changeChannel(1000);

    }

    //Hashcode tests///////////////////////////////////////////////////
    @Test (expected = IllegalArgumentException.class)
    public void hashCode_shouldReturnSameValue_whenEqualObjects() {
        assertEquals(tv1.hashCode(),tv2.hashCode());
    }

    //equals//////////////////////////////////////////////////////////


    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(tv1,tv2);
    }

    @Test
    public void equals_shouldReturnFalse_differentBrand_sameVolume_differentDisplay() {
        tv1.setBrand("Samsung");
        assertNotEquals(tv1,tv2);
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_differentVolume_sameDisplay() {
        tv1.setVolume(60);
        assertNotEquals(tv1,tv2);
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_sameVolume_differentDisplay() {
        tv1.setDisplay(DisplayType.LCD);
        assertNotEquals(tv1,tv2);
    }


}