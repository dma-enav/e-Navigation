package dk.dma.enav.model.ship;

import java.util.ArrayList;
import java.util.List;

public enum ShipType {
    
	ANTI_POLLUTION, CARGO, DIVING, DREDGING, FISHING, HSC, LAW_ENFORCEMENT, MEDICAL, MILITARY, PASSENGER, CRUISE_SHIP, PILOT, PLEASURE, PORT_TENDER, SAILING, SAR, TANKER, TOWING, TOWING_LONG_WIDE, TUG, UNDEFINED, UNKNOWN, WIG;
    
    public static List<String> getStringList() {
    	List<String> list = new ArrayList<>();
    	for (ShipType type : values()) {
			list.add(type.toString());
		}
    	return list;
    }
}
