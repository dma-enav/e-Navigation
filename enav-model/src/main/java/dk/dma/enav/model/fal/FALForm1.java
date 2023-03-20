/* Copyright (c) 2011 Danish Maritime Authority.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.dma.enav.model.fal;

import java.io.Serializable;

/**
 * The type Fal form 1.
 */
public class FALForm1 implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The Arrival.
     */
// If false is depature
    boolean arrival;

    private String nameAndTypeOfShip = "";
    private String imoNumber = "";
    private String callSign = "";
    private String voyageNumber;
    private String portOfArrivalDeapture = "";
    private String DateAndTimeOfArrivalDepature = "";
    private String flagStateOfShip = "";
    private String nameOfMaster = "";
    private String lastPortOfCall = "";
    private String certificateOfRegistry = "";
    private String grossTonnage = "";
    private String nameAndContactDetalsOfShipsAgent = "";
    private String netTonnage = "";
    private String positionOfTheShip = "";
    private String briefParticulars = "";
    private String briefDescriptionOfCargo = "";
    private String numberOfCrew = "";
    private String numberOfPassengers = "";
    private String remarks = "";

    private int cargoDeclarationCount;
    private int shipStoresDeclarationCount;
    private int crewListCount;
    private int passengerListCount;
    private int crewEffectsDeclarationCount;
    private int maritimeDeclarationOfHealthCount;

    private String shipWasteRequirements;
    private String signature;

    /**
     * Instantiates a new Fal form 1.
     */
    public FALForm1() {

    }

    /**
     * Instantiates a new Fal form 1.
     *
     * @param arrival                          the arrival
     * @param nameAndTypeOfShip                the name and type of ship
     * @param imoNumber                        the imo number
     * @param callSign                         the call sign
     * @param voyageNumber                     the voyage number
     * @param portOfArrivalDeapture            the port of arrival deapture
     * @param dateAndTimeOfArrivalDepature     the date and time of arrival depature
     * @param flagStateOfShip                  the flag state of ship
     * @param nameOfMaster                     the name of master
     * @param lastPortOfCall                   the last port of call
     * @param certificateOfRegistry            the certificate of registry
     * @param grossTonnage                     the gross tonnage
     * @param nameAndContactDetalsOfShipsAgent the name and contact detals of ships agent
     * @param netTonnage                       the net tonnage
     * @param positionOfTheShip                the position of the ship
     * @param briefParticulars                 the brief particulars
     * @param briefDescriptionOfCargo          the brief description of cargo
     * @param numberOfCrew                     the number of crew
     * @param numberOfPassengers               the number of passengers
     * @param remarks                          the remarks
     * @param cargoDeclarationCount            the cargo declaration count
     * @param shipStoresDeclarationCount       the ship stores declaration count
     * @param crewListCount                    the crew list count
     * @param passengerListCount               the passenger list count
     * @param crewEffectsDeclarationCount      the crew effects declaration count
     * @param maritimeDeclarationOfHealthCount the maritime declaration of health count
     * @param shipWasteRequirements            the ship waste requirements
     * @param signature                        the signature
     */
    public FALForm1(boolean arrival, String nameAndTypeOfShip, String imoNumber, String callSign, String voyageNumber,
            String portOfArrivalDeapture, String dateAndTimeOfArrivalDepature, String flagStateOfShip, String nameOfMaster,
            String lastPortOfCall, String certificateOfRegistry, String grossTonnage, String nameAndContactDetalsOfShipsAgent,
            String netTonnage, String positionOfTheShip, String briefParticulars, String briefDescriptionOfCargo,
            String numberOfCrew, String numberOfPassengers, String remarks, int cargoDeclarationCount,
            int shipStoresDeclarationCount, int crewListCount, int passengerListCount, int crewEffectsDeclarationCount,
            int maritimeDeclarationOfHealthCount, String shipWasteRequirements, String signature) {
        this.arrival = arrival;
        this.nameAndTypeOfShip = nameAndTypeOfShip;
        this.imoNumber = imoNumber;
        this.callSign = callSign;
        this.voyageNumber = voyageNumber;
        this.portOfArrivalDeapture = portOfArrivalDeapture;
        DateAndTimeOfArrivalDepature = dateAndTimeOfArrivalDepature;
        this.flagStateOfShip = flagStateOfShip;
        this.nameOfMaster = nameOfMaster;
        this.lastPortOfCall = lastPortOfCall;
        this.certificateOfRegistry = certificateOfRegistry;
        this.grossTonnage = grossTonnage;
        this.nameAndContactDetalsOfShipsAgent = nameAndContactDetalsOfShipsAgent;
        this.netTonnage = netTonnage;
        this.positionOfTheShip = positionOfTheShip;
        this.briefParticulars = briefParticulars;
        this.briefDescriptionOfCargo = briefDescriptionOfCargo;
        this.numberOfCrew = numberOfCrew;
        this.numberOfPassengers = numberOfPassengers;
        this.remarks = remarks;
        this.cargoDeclarationCount = cargoDeclarationCount;
        this.shipStoresDeclarationCount = shipStoresDeclarationCount;
        this.crewListCount = crewListCount;
        this.passengerListCount = passengerListCount;
        this.crewEffectsDeclarationCount = crewEffectsDeclarationCount;
        this.maritimeDeclarationOfHealthCount = maritimeDeclarationOfHealthCount;
        this.shipWasteRequirements = shipWasteRequirements;
        this.signature = signature;
    }

    /**
     * Is arrival boolean.
     *
     * @return the arrival
     */
    public boolean isArrival() {
        return arrival;
    }

    /**
     * Sets arrival.
     *
     * @param arrival the arrival to set
     */
    public void setArrival(boolean arrival) {
        this.arrival = arrival;
    }

    /**
     * Gets name and type of ship.
     *
     * @return the nameAndTypeOfShip
     */
    public String getNameAndTypeOfShip() {
        return nameAndTypeOfShip;
    }

    /**
     * Sets name and type of ship.
     *
     * @param nameAndTypeOfShip the nameAndTypeOfShip to set
     */
    public void setNameAndTypeOfShip(String nameAndTypeOfShip) {
        this.nameAndTypeOfShip = nameAndTypeOfShip;
    }

    /**
     * Gets imo number.
     *
     * @return the imoNumber
     */
    public String getImoNumber() {
        return imoNumber;
    }

    /**
     * Sets imo number.
     *
     * @param imoNumber the imoNumber to set
     */
    public void setImoNumber(String imoNumber) {
        this.imoNumber = imoNumber;
    }

    /**
     * Gets call sign.
     *
     * @return the callSign
     */
    public String getCallSign() {
        return callSign;
    }

    /**
     * Sets call sign.
     *
     * @param callSign the callSign to set
     */
    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    /**
     * Gets voyage number.
     *
     * @return the voyageNumber
     */
    public String getVoyageNumber() {
        return voyageNumber;
    }

    /**
     * Sets voyage number.
     *
     * @param voyageNumber the voyageNumber to set
     */
    public void setVoyageNumber(String voyageNumber) {
        this.voyageNumber = voyageNumber;
    }

    /**
     * Gets port of arrival deapture.
     *
     * @return the portOfArrivalDeapture
     */
    public String getPortOfArrivalDeapture() {
        return portOfArrivalDeapture;
    }

    /**
     * Sets port of arrival deapture.
     *
     * @param portOfArrivalDeapture the portOfArrivalDeapture to set
     */
    public void setPortOfArrivalDeapture(String portOfArrivalDeapture) {
        this.portOfArrivalDeapture = portOfArrivalDeapture;
    }

    /**
     * Gets date and time of arrival depature.
     *
     * @return the dateAndTimeOfArrivalDepature
     */
    public String getDateAndTimeOfArrivalDepature() {
        return DateAndTimeOfArrivalDepature;
    }

    /**
     * Sets date and time of arrival depature.
     *
     * @param dateAndTimeOfArrivalDepature the dateAndTimeOfArrivalDepature to set
     */
    public void setDateAndTimeOfArrivalDepature(String dateAndTimeOfArrivalDepature) {
        DateAndTimeOfArrivalDepature = dateAndTimeOfArrivalDepature;
    }

    /**
     * Gets flag state of ship.
     *
     * @return the flagStateOfShip
     */
    public String getFlagStateOfShip() {
        return flagStateOfShip;
    }

    /**
     * Sets flag state of ship.
     *
     * @param flagStateOfShip the flagStateOfShip to set
     */
    public void setFlagStateOfShip(String flagStateOfShip) {
        this.flagStateOfShip = flagStateOfShip;
    }

    /**
     * Gets name of master.
     *
     * @return the nameOfMaster
     */
    public String getNameOfMaster() {
        return nameOfMaster;
    }

    /**
     * Sets name of master.
     *
     * @param nameOfMaster the nameOfMaster to set
     */
    public void setNameOfMaster(String nameOfMaster) {
        this.nameOfMaster = nameOfMaster;
    }

    /**
     * Gets last port of call.
     *
     * @return the lastPortOfCall
     */
    public String getLastPortOfCall() {
        return lastPortOfCall;
    }

    /**
     * Sets last port of call.
     *
     * @param lastPortOfCall the lastPortOfCall to set
     */
    public void setLastPortOfCall(String lastPortOfCall) {
        this.lastPortOfCall = lastPortOfCall;
    }

    /**
     * Gets certificate of registry.
     *
     * @return the certificateOfRegistry
     */
    public String getCertificateOfRegistry() {
        return certificateOfRegistry;
    }

    /**
     * Sets certificate of registry.
     *
     * @param certificateOfRegistry the certificateOfRegistry to set
     */
    public void setCertificateOfRegistry(String certificateOfRegistry) {
        this.certificateOfRegistry = certificateOfRegistry;
    }

    /**
     * Gets gross tonnage.
     *
     * @return the grossTonnage
     */
    public String getGrossTonnage() {
        return grossTonnage;
    }

    /**
     * Sets gross tonnage.
     *
     * @param grossTonnage the grossTonnage to set
     */
    public void setGrossTonnage(String grossTonnage) {
        this.grossTonnage = grossTonnage;
    }

    /**
     * Gets name and contact detals of ships agent.
     *
     * @return the nameAndContactDetalsOfShipsAgent
     */
    public String getNameAndContactDetalsOfShipsAgent() {
        return nameAndContactDetalsOfShipsAgent;
    }

    /**
     * Sets name and contact detals of ships agent.
     *
     * @param nameAndContactDetalsOfShipsAgent the nameAndContactDetalsOfShipsAgent to set
     */
    public void setNameAndContactDetalsOfShipsAgent(String nameAndContactDetalsOfShipsAgent) {
        this.nameAndContactDetalsOfShipsAgent = nameAndContactDetalsOfShipsAgent;
    }

    /**
     * Gets net tonnage.
     *
     * @return the netTonnage
     */
    public String getNetTonnage() {
        return netTonnage;
    }

    /**
     * Sets net tonnage.
     *
     * @param netTonnage the netTonnage to set
     */
    public void setNetTonnage(String netTonnage) {
        this.netTonnage = netTonnage;
    }

    /**
     * Gets position of the ship.
     *
     * @return the positionOfTheShip
     */
    public String getPositionOfTheShip() {
        return positionOfTheShip;
    }

    /**
     * Sets position of the ship.
     *
     * @param positionOfTheShip the positionOfTheShip to set
     */
    public void setPositionOfTheShip(String positionOfTheShip) {
        this.positionOfTheShip = positionOfTheShip;
    }

    /**
     * Gets brief particulars.
     *
     * @return the briefParticulars
     */
    public String getBriefParticulars() {
        return briefParticulars;
    }

    /**
     * Sets brief particulars.
     *
     * @param briefParticulars the briefParticulars to set
     */
    public void setBriefParticulars(String briefParticulars) {
        this.briefParticulars = briefParticulars;
    }

    /**
     * Gets brief description of cargo.
     *
     * @return the briefDescriptionOfCargo
     */
    public String getBriefDescriptionOfCargo() {
        return briefDescriptionOfCargo;
    }

    /**
     * Sets brief description of cargo.
     *
     * @param briefDescriptionOfCargo the briefDescriptionOfCargo to set
     */
    public void setBriefDescriptionOfCargo(String briefDescriptionOfCargo) {
        this.briefDescriptionOfCargo = briefDescriptionOfCargo;
    }

    /**
     * Gets number of crew.
     *
     * @return the numberOfCrew
     */
    public String getNumberOfCrew() {
        return numberOfCrew;
    }

    /**
     * Sets number of crew.
     *
     * @param numberOfCrew the numberOfCrew to set
     */
    public void setNumberOfCrew(String numberOfCrew) {
        this.numberOfCrew = numberOfCrew;
    }

    /**
     * Gets number of passengers.
     *
     * @return the numberOfPassengers
     */
    public String getNumberOfPassengers() {
        return numberOfPassengers;
    }

    /**
     * Sets number of passengers.
     *
     * @param numberOfPassengers the numberOfPassengers to set
     */
    public void setNumberOfPassengers(String numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    /**
     * Gets remarks.
     *
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets remarks.
     *
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * Gets cargo declaration count.
     *
     * @return the cargoDeclarationCount
     */
    public int getCargoDeclarationCount() {
        return cargoDeclarationCount;
    }

    /**
     * Sets cargo declaration count.
     *
     * @param cargoDeclarationCount the cargoDeclarationCount to set
     */
    public void setCargoDeclarationCount(int cargoDeclarationCount) {
        this.cargoDeclarationCount = cargoDeclarationCount;
    }

    /**
     * Gets ship stores declaration count.
     *
     * @return the shipStoresDeclarationCount
     */
    public int getShipStoresDeclarationCount() {
        return shipStoresDeclarationCount;
    }

    /**
     * Sets ship stores declaration count.
     *
     * @param shipStoresDeclarationCount the shipStoresDeclarationCount to set
     */
    public void setShipStoresDeclarationCount(int shipStoresDeclarationCount) {
        this.shipStoresDeclarationCount = shipStoresDeclarationCount;
    }

    /**
     * Gets crew list count.
     *
     * @return the crewListCount
     */
    public int getCrewListCount() {
        return crewListCount;
    }

    /**
     * Sets crew list count.
     *
     * @param crewListCount the crewListCount to set
     */
    public void setCrewListCount(int crewListCount) {
        this.crewListCount = crewListCount;
    }

    /**
     * Gets passenger list count.
     *
     * @return the passengerListCount
     */
    public int getPassengerListCount() {
        return passengerListCount;
    }

    /**
     * Sets passenger list count.
     *
     * @param passengerListCount the passengerListCount to set
     */
    public void setPassengerListCount(int passengerListCount) {
        this.passengerListCount = passengerListCount;
    }

    /**
     * Gets crew effects declaration count.
     *
     * @return the crewEffectsDeclarationCount
     */
    public int getCrewEffectsDeclarationCount() {
        return crewEffectsDeclarationCount;
    }

    /**
     * Sets crew effects declaration count.
     *
     * @param crewEffectsDeclarationCount the crewEffectsDeclarationCount to set
     */
    public void setCrewEffectsDeclarationCount(int crewEffectsDeclarationCount) {
        this.crewEffectsDeclarationCount = crewEffectsDeclarationCount;
    }

    /**
     * Gets maritime declaration of health count.
     *
     * @return the maritimeDeclarationOfHealthCount
     */
    public int getMaritimeDeclarationOfHealthCount() {
        return maritimeDeclarationOfHealthCount;
    }

    /**
     * Sets maritime declaration of health count.
     *
     * @param maritimeDeclarationOfHealthCount the maritimeDeclarationOfHealthCount to set
     */
    public void setMaritimeDeclarationOfHealthCount(int maritimeDeclarationOfHealthCount) {
        this.maritimeDeclarationOfHealthCount = maritimeDeclarationOfHealthCount;
    }

    /**
     * Gets ship waste requirements.
     *
     * @return the shipWasteRequirements
     */
    public String getShipWasteRequirements() {
        return shipWasteRequirements;
    }

    /**
     * Sets ship waste requirements.
     *
     * @param shipWasteRequirements the shipWasteRequirements to set
     */
    public void setShipWasteRequirements(String shipWasteRequirements) {
        this.shipWasteRequirements = shipWasteRequirements;
    }

    /**
     * Gets signature.
     *
     * @return the signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets signature.
     *
     * @param signature the signature to set
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FALForm1 [arrival=" + arrival + ", nameAndTypeOfShip=" + nameAndTypeOfShip + ", imoNumber=" + imoNumber
                + ", callSign=" + callSign + ", voyageNumber=" + voyageNumber + ", portOfArrivalDeapture=" + portOfArrivalDeapture
                + ", DateAndTimeOfArrivalDepature=" + DateAndTimeOfArrivalDepature + ", flagStateOfShip=" + flagStateOfShip
                + ", nameOfMaster=" + nameOfMaster + ", lastPortOfCall=" + lastPortOfCall + ", certificateOfRegistry="
                + certificateOfRegistry + ", grossTonnage=" + grossTonnage + ", nameAndContactDetalsOfShipsAgent="
                + nameAndContactDetalsOfShipsAgent + ", netTonnage=" + netTonnage + ", positionOfTheShip=" + positionOfTheShip
                + ", briefParticulars=" + briefParticulars + ", briefDescriptionOfCargo=" + briefDescriptionOfCargo
                + ", numberOfCrew=" + numberOfCrew + ", numberOfPassengers=" + numberOfPassengers + ", remarks=" + remarks
                + ", cargoDeclarationCount=" + cargoDeclarationCount + ", shipStoresDeclarationCount=" + shipStoresDeclarationCount
                + ", crewListCount=" + crewListCount + ", passengerListCount=" + passengerListCount
                + ", crewEffectsDeclarationCount=" + crewEffectsDeclarationCount + ", maritimeDeclarationOfHealthCount="
                + maritimeDeclarationOfHealthCount + ", shipWasteRequirements=" + shipWasteRequirements + ", signature="
                + signature + "]";
    }

    
    
    
}
