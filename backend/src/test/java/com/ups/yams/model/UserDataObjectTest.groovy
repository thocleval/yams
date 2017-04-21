package com.ups.yams.model

import spock.lang.Specification

/**
 * Created by adnane on 07/04/2017.
 */
class UserDataObjectTest extends Specification {
    def "GetId"() {

    }

    def "SetId"() {

    }

    def "GetFirstName"() {
        given : "getting the first name"
        String name = "name1";
        UserDataObject user = new UserDataObject();
        user.setFirstName(name);
        expect :
        user.getFirstName()==name;
    }

    def "SetFirstName"() {

    }

    def "GetLastName"() {

    }

    def "SetLastName"() {

    }

    def "GetPassword"() {

    }

    def "SetPassword"() {

    }

    def "GetMatchingPassword"() {

    }

    def "SetMatchingPassword"() {

    }

    def "GetEmail"() {

    }

    def "SetEmail"() {

    }
}
