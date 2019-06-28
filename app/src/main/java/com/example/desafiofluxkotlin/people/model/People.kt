package com.example.desafiofluxkotlin.people.model

import android.os.Parcel
import android.os.Parcelable

import java.util.ArrayList

class People : Parcelable {

    /**
     * results : [{"gender":"male","name":{"title":"mr","first":"gordon","last":"hamilton"},"location":{"street":"3111 queen street","city":"salford","state":"greater manchester","postcode":"GJ74 3WS","coordinates":{"latitude":"15.1436","longitude":"-165.4709"},"timezone":{"offset":"-3:30","description":"Newfoundland"}},"email":"gordon.hamilton@example.com","login":{"uuid":"6554ab66-322a-44db-92b0-7849d5e1278a","username":"sadbear521","password":"bondage","salt":"nijPqYT2","md5":"b6d7609e04e6c626703317e1a8c92812","sha1":"d39101e7effc1949ad365183ffb8a756843cd265","sha256":"f9a7772eb4a67a2de6d815440e098cda2d4c9bcc224f8f485bbf185bd3843cc6"},"dob":{"date":"1972-12-04T07:41:57Z","age":46},"registered":{"date":"2006-10-05T17:37:07Z","age":12},"phone":"013873 99949","cell":"0756-900-412","id":{"name":"NINO","value":"LH 07 79 45 H"},"picture":{"large":"https://randomuser.me/api/portraits/men/57.jpg","medium":"https://randomuser.me/api/portraits/med/men/57.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/men/57.jpg"},"nat":"GB"}]
     * info : {"seed":"b0b56ded400c0f51","results":1,"page":1,"version":"1.2"}
     */

    var info: InfoBean? = null
    var results: List<ResultsBean>? = null

    class InfoBean : Parcelable {
        /**
         * seed : b0b56ded400c0f51
         * results : 1
         * page : 1
         * version : 1.2
         */

        var seed: String? = null
        var results: Int = 0
        var page: Int = 0
        var version: String? = null

        override fun describeContents(): Int {
            return 0
        }

        override fun writeToParcel(dest: Parcel, flags: Int) {
            dest.writeString(this.seed)
            dest.writeInt(this.results)
            dest.writeInt(this.page)
            dest.writeString(this.version)
        }

        constructor() {}

        protected constructor(`in`: Parcel) {
            this.seed = `in`.readString()
            this.results = `in`.readInt()
            this.page = `in`.readInt()
            this.version = `in`.readString()
        }

        companion object CREATOR : Parcelable.Creator<InfoBean> {
            override fun createFromParcel(parcel: Parcel): InfoBean {
                return InfoBean(parcel)
            }

            override fun newArray(size: Int): Array<InfoBean?> {
                return arrayOfNulls(size)
            }
        }
    }

    class ResultsBean : Parcelable {
        /**
         * gender : male
         * name : {"title":"mr","first":"gordon","last":"hamilton"}
         * location : {"street":"3111 queen street","city":"salford","state":"greater manchester","postcode":"GJ74 3WS","coordinates":{"latitude":"15.1436","longitude":"-165.4709"},"timezone":{"offset":"-3:30","description":"Newfoundland"}}
         * email : gordon.hamilton@example.com
         * login : {"uuid":"6554ab66-322a-44db-92b0-7849d5e1278a","username":"sadbear521","password":"bondage","salt":"nijPqYT2","md5":"b6d7609e04e6c626703317e1a8c92812","sha1":"d39101e7effc1949ad365183ffb8a756843cd265","sha256":"f9a7772eb4a67a2de6d815440e098cda2d4c9bcc224f8f485bbf185bd3843cc6"}
         * dob : {"date":"1972-12-04T07:41:57Z","age":46}
         * registered : {"date":"2006-10-05T17:37:07Z","age":12}
         * phone : 013873 99949
         * cell : 0756-900-412
         * id : {"name":"NINO","value":"LH 07 79 45 H"}
         * picture : {"large":"https://randomuser.me/api/portraits/men/57.jpg","medium":"https://randomuser.me/api/portraits/med/men/57.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/men/57.jpg"}
         * nat : GB
         */

        var gender: String? = null
        var name: NameBean? = null
        var location: LocationBean? = null
        var email: String? = null
        var login: LoginBean? = null
        var dob: DobBean? = null
        var registered: RegisteredBean? = null
        var phone: String? = null
        var cell: String? = null
        var id: IdBean? = null
        var picture: PictureBean? = null
        var nat: String? = null

        class NameBean : Parcelable {
            /**
             * title : mr
             * first : gordon
             * last : hamilton
             */

            var title: String? = null
            var first: String? = null
            var last: String? = null

            override fun describeContents(): Int {
                return 0
            }

            override fun writeToParcel(dest: Parcel, flags: Int) {
                dest.writeString(this.title)
                dest.writeString(this.first)
                dest.writeString(this.last)
            }

            constructor() {}

            protected constructor(`in`: Parcel) {
                this.title = `in`.readString()
                this.first = `in`.readString()
                this.last = `in`.readString()
            }

            companion object CREATOR : Parcelable.Creator<NameBean> {
                override fun createFromParcel(parcel: Parcel): NameBean {
                    return NameBean(parcel)
                }

                override fun newArray(size: Int): Array<NameBean?> {
                    return arrayOfNulls(size)
                }
            }
        }

        class LocationBean : Parcelable {
            /**
             * street : 3111 queen street
             * city : salford
             * state : greater manchester
             * postcode : GJ74 3WS
             * coordinates : {"latitude":"15.1436","longitude":"-165.4709"}
             * timezone : {"offset":"-3:30","description":"Newfoundland"}
             */

            var street: String? = null
            var city: String? = null
            var state: String? = null
            var postcode: String? = null
            var coordinates: CoordinatesBean? = null
            var timezone: TimezoneBean? = null

            class CoordinatesBean : Parcelable {
                /**
                 * latitude : 15.1436
                 * longitude : -165.4709
                 */

                var latitude: String? = null
                var longitude: String? = null

                override fun describeContents(): Int {
                    return 0
                }

                override fun writeToParcel(dest: Parcel, flags: Int) {
                    dest.writeString(this.latitude)
                    dest.writeString(this.longitude)
                }

                constructor() {}

                protected constructor(`in`: Parcel) {
                    this.latitude = `in`.readString()
                    this.longitude = `in`.readString()
                }

                companion object CREATOR : Parcelable.Creator<CoordinatesBean> {
                    override fun createFromParcel(parcel: Parcel): CoordinatesBean {
                        return CoordinatesBean(parcel)
                    }

                    override fun newArray(size: Int): Array<CoordinatesBean?> {
                        return arrayOfNulls(size)
                    }
                }
            }

            class TimezoneBean : Parcelable {
                /**
                 * offset : -3:30
                 * description : Newfoundland
                 */

                var offset: String? = null
                var description: String? = null

                override fun describeContents(): Int {
                    return 0
                }

                override fun writeToParcel(dest: Parcel, flags: Int) {
                    dest.writeString(this.offset)
                    dest.writeString(this.description)
                }

                constructor() {}

                protected constructor(`in`: Parcel) {
                    this.offset = `in`.readString()
                    this.description = `in`.readString()
                }

                companion object CREATOR : Parcelable.Creator<TimezoneBean> {
                    override fun createFromParcel(parcel: Parcel): TimezoneBean {
                        return TimezoneBean(parcel)
                    }

                    override fun newArray(size: Int): Array<TimezoneBean?> {
                        return arrayOfNulls(size)
                    }
                }
            }

            constructor() {}

            override fun describeContents(): Int {
                return 0
            }

            override fun writeToParcel(dest: Parcel, flags: Int) {
                dest.writeString(this.street)
                dest.writeString(this.city)
                dest.writeString(this.state)
                dest.writeString(this.postcode)
                dest.writeParcelable(this.coordinates, flags)
                dest.writeParcelable(this.timezone, flags)
            }

            protected constructor(`in`: Parcel) {
                this.street = `in`.readString()
                this.city = `in`.readString()
                this.state = `in`.readString()
                this.postcode = `in`.readString()
                this.coordinates = `in`.readParcelable(CoordinatesBean::class.java.classLoader)
                this.timezone = `in`.readParcelable(TimezoneBean::class.java.classLoader)
            }

            companion object CREATOR : Parcelable.Creator<LocationBean> {
                override fun createFromParcel(parcel: Parcel): LocationBean {
                    return LocationBean(parcel)
                }

                override fun newArray(size: Int): Array<LocationBean?> {
                    return arrayOfNulls(size)
                }
            }
        }

        class LoginBean : Parcelable {
            /**
             * uuid : 6554ab66-322a-44db-92b0-7849d5e1278a
             * username : sadbear521
             * password : bondage
             * salt : nijPqYT2
             * md5 : b6d7609e04e6c626703317e1a8c92812
             * sha1 : d39101e7effc1949ad365183ffb8a756843cd265
             * sha256 : f9a7772eb4a67a2de6d815440e098cda2d4c9bcc224f8f485bbf185bd3843cc6
             */

            var uuid: String? = null
            var username: String? = null
            var password: String? = null
            var salt: String? = null
            var md5: String? = null
            var sha1: String? = null
            var sha256: String? = null

            override fun describeContents(): Int {
                return 0
            }

            override fun writeToParcel(dest: Parcel, flags: Int) {
                dest.writeString(this.uuid)
                dest.writeString(this.username)
                dest.writeString(this.password)
                dest.writeString(this.salt)
                dest.writeString(this.md5)
                dest.writeString(this.sha1)
                dest.writeString(this.sha256)
            }

            constructor() {}

            protected constructor(`in`: Parcel) {
                this.uuid = `in`.readString()
                this.username = `in`.readString()
                this.password = `in`.readString()
                this.salt = `in`.readString()
                this.md5 = `in`.readString()
                this.sha1 = `in`.readString()
                this.sha256 = `in`.readString()
            }

            companion object CREATOR : Parcelable.Creator<LoginBean> {
                override fun createFromParcel(parcel: Parcel): LoginBean {
                    return LoginBean(parcel)
                }

                override fun newArray(size: Int): Array<LoginBean?> {
                    return arrayOfNulls(size)
                }
            }
        }

        class DobBean : Parcelable {
            /**
             * date : 1972-12-04T07:41:57Z
             * age : 46
             */

            var date: String? = null
            var age: Int = 0

            override fun describeContents(): Int {
                return 0
            }

            override fun writeToParcel(dest: Parcel, flags: Int) {
                dest.writeString(this.date)
                dest.writeInt(this.age)
            }

            constructor() {}

            protected constructor(`in`: Parcel) {
                this.date = `in`.readString()
                this.age = `in`.readInt()
            }

            companion object CREATOR : Parcelable.Creator<DobBean> {
                override fun createFromParcel(parcel: Parcel): DobBean {
                    return DobBean(parcel)
                }

                override fun newArray(size: Int): Array<DobBean?> {
                    return arrayOfNulls(size)
                }
            }
        }

        class RegisteredBean : Parcelable {
            /**
             * date : 2006-10-05T17:37:07Z
             * age : 12
             */

            var date: String? = null
            var age: Int = 0

            override fun describeContents(): Int {
                return 0
            }

            override fun writeToParcel(dest: Parcel, flags: Int) {
                dest.writeString(this.date)
                dest.writeInt(this.age)
            }

            constructor() {}

            protected constructor(`in`: Parcel) {
                this.date = `in`.readString()
                this.age = `in`.readInt()
            }

            companion object CREATOR : Parcelable.Creator<RegisteredBean> {
                override fun createFromParcel(parcel: Parcel): RegisteredBean {
                    return RegisteredBean(parcel)
                }

                override fun newArray(size: Int): Array<RegisteredBean?> {
                    return arrayOfNulls(size)
                }
            }
        }

        class IdBean : Parcelable {
            /**
             * name : NINO
             * value : LH 07 79 45 H
             */

            var name: String? = null
            var value: String? = null

            override fun describeContents(): Int {
                return 0
            }

            override fun writeToParcel(dest: Parcel, flags: Int) {
                dest.writeString(this.name)
                dest.writeString(this.value)
            }

            constructor() {}

            protected constructor(`in`: Parcel) {
                this.name = `in`.readString()
                this.value = `in`.readString()
            }

            companion object CREATOR : Parcelable.Creator<IdBean> {
                override fun createFromParcel(parcel: Parcel): IdBean {
                    return IdBean(parcel)
                }

                override fun newArray(size: Int): Array<IdBean?> {
                    return arrayOfNulls(size)
                }
            }
        }

        class PictureBean : Parcelable {
            /**
             * large : https://randomuser.me/api/portraits/men/57.jpg
             * medium : https://randomuser.me/api/portraits/med/men/57.jpg
             * thumbnail : https://randomuser.me/api/portraits/thumb/men/57.jpg
             */

            var large: String? = null
            var medium: String? = null
            var thumbnail: String? = null

            override fun describeContents(): Int {
                return 0
            }

            override fun writeToParcel(dest: Parcel, flags: Int) {
                dest.writeString(this.large)
                dest.writeString(this.medium)
                dest.writeString(this.thumbnail)
            }

            constructor() {}

            protected constructor(`in`: Parcel) {
                this.large = `in`.readString()
                this.medium = `in`.readString()
                this.thumbnail = `in`.readString()
            }

            companion object CREATOR : Parcelable.Creator<PictureBean> {
                override fun createFromParcel(parcel: Parcel): PictureBean {
                    return PictureBean(parcel)
                }

                override fun newArray(size: Int): Array<PictureBean?> {
                    return arrayOfNulls(size)
                }
            }
        }

        override fun describeContents(): Int {
            return 0
        }

        override fun writeToParcel(dest: Parcel, flags: Int) {
            dest.writeString(this.gender)
            dest.writeParcelable(this.name, flags)
            dest.writeParcelable(this.location, flags)
            dest.writeString(this.email)
            dest.writeParcelable(this.login, flags)
            dest.writeParcelable(this.dob, flags)
            dest.writeParcelable(this.registered, flags)
            dest.writeString(this.phone)
            dest.writeString(this.cell)
            dest.writeParcelable(this.id, flags)
            dest.writeParcelable(this.picture, flags)
            dest.writeString(this.nat)
        }

        constructor() {}

        protected constructor(`in`: Parcel) {
            this.gender = `in`.readString()
            this.name = `in`.readParcelable(NameBean::class.java.classLoader)
            this.location = `in`.readParcelable(LocationBean::class.java.classLoader)
            this.email = `in`.readString()
            this.login = `in`.readParcelable(LoginBean::class.java.classLoader)
            this.dob = `in`.readParcelable(DobBean::class.java.classLoader)
            this.registered = `in`.readParcelable(RegisteredBean::class.java.classLoader)
            this.phone = `in`.readString()
            this.cell = `in`.readString()
            this.id = `in`.readParcelable(IdBean::class.java.classLoader)
            this.picture = `in`.readParcelable(PictureBean::class.java.classLoader)
            this.nat = `in`.readString()
        }

        companion object CREATOR : Parcelable.Creator<ResultsBean> {
            override fun createFromParcel(parcel: Parcel): ResultsBean {
                return ResultsBean(parcel)
            }

            override fun newArray(size: Int): Array<ResultsBean?> {
                return arrayOfNulls(size)
            }
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeParcelable(this.info, flags)
        dest.writeList(this.results)
    }

    constructor() {}

    protected constructor(`in`: Parcel) {
        this.info = `in`.readParcelable(InfoBean::class.java.classLoader)
        this.results = ArrayList()
        `in`.readList(this.results, ResultsBean::class.java.classLoader)
    }

    companion object CREATOR : Parcelable.Creator<People> {
        override fun createFromParcel(parcel: Parcel): People {
            return People(parcel)
        }

        override fun newArray(size: Int): Array<People?> {
            return arrayOfNulls(size)
        }
    }
}
