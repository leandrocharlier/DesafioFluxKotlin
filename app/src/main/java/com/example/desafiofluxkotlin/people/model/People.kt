package com.example.desafiofluxkotlin.people.model

class People {
    /**
     * results : [{"gender":"male","name":{"title":"mr","first":"philippe","last":"abraham"},"location":{"street":"5762 grand ave","city":"cumberland","state":"newfoundland and labrador","postcode":"M7T 8D8","coordinates":{"latitude":"-59.7322","longitude":"-28.4732"},"timezone":{"offset":"+9:00","description":"Tokyo, Seoul, Osaka, Sapporo, Yakutsk"}},"email":"philippe.abraham@example.com","login":{"uuid":"c0d98354-3417-4c3e-a90d-a8437956e15c","username":"angryswan702","password":"melvin","salt":"nrfCXo6y","md5":"5d2deb7728b5a1a432b1e85029e6c68a","sha1":"97bacc58401741ee832d20925c79bae7a47e42e6","sha256":"bcd1ba058e8c8798403053c8dfeeda8cd8f209436bb3a72a1d4e4e376a852798"},"dob":{"date":"1973-01-14T17:33:48Z","age":46},"registered":{"date":"2006-08-25T02:12:26Z","age":12},"phone":"453-390-3702","cell":"053-670-2575","id":{"name":"","value":null},"picture":{"large":"https://randomuser.me/api/portraits/men/22.jpg","medium":"https://randomuser.me/api/portraits/med/men/22.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/men/22.jpg"},"nat":"CA"}]
     * info : {"seed":"937fe2a29fa02806","results":1,"page":1,"version":"1.2"}
     */

    var info: InfoBean? = null
    var results: List<ResultsBean>? = null

    class InfoBean {
        /**
         * seed : 937fe2a29fa02806
         * results : 1
         * page : 1
         * version : 1.2
         */

        var seed: String? = null
        var results: Int = 0
        var page: Int = 0
        var version: String? = null
    }

    class ResultsBean {
        /**
         * gender : male
         * name : {"title":"mr","first":"philippe","last":"abraham"}
         * location : {"street":"5762 grand ave","city":"cumberland","state":"newfoundland and labrador","postcode":"M7T 8D8","coordinates":{"latitude":"-59.7322","longitude":"-28.4732"},"timezone":{"offset":"+9:00","description":"Tokyo, Seoul, Osaka, Sapporo, Yakutsk"}}
         * email : philippe.abraham@example.com
         * login : {"uuid":"c0d98354-3417-4c3e-a90d-a8437956e15c","username":"angryswan702","password":"melvin","salt":"nrfCXo6y","md5":"5d2deb7728b5a1a432b1e85029e6c68a","sha1":"97bacc58401741ee832d20925c79bae7a47e42e6","sha256":"bcd1ba058e8c8798403053c8dfeeda8cd8f209436bb3a72a1d4e4e376a852798"}
         * dob : {"date":"1973-01-14T17:33:48Z","age":46}
         * registered : {"date":"2006-08-25T02:12:26Z","age":12}
         * phone : 453-390-3702
         * cell : 053-670-2575
         * id : {"name":"","value":null}
         * picture : {"large":"https://randomuser.me/api/portraits/men/22.jpg","medium":"https://randomuser.me/api/portraits/med/men/22.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/men/22.jpg"}
         * nat : CA
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

        class NameBean {
            /**
             * title : mr
             * first : philippe
             * last : abraham
             */

            var title: String? = null
            var first: String? = null
            var last: String? = null
        }

        class LocationBean {
            /**
             * street : 5762 grand ave
             * city : cumberland
             * state : newfoundland and labrador
             * postcode : M7T 8D8
             * coordinates : {"latitude":"-59.7322","longitude":"-28.4732"}
             * timezone : {"offset":"+9:00","description":"Tokyo, Seoul, Osaka, Sapporo, Yakutsk"}
             */

            var street: String? = null
            var city: String? = null
            var state: String? = null
            var postcode: String? = null
            var coordinates: CoordinatesBean? = null
            var timezone: TimezoneBean? = null

            class CoordinatesBean {
                /**
                 * latitude : -59.7322
                 * longitude : -28.4732
                 */

                var latitude: String? = null
                var longitude: String? = null
            }

            class TimezoneBean {
                /**
                 * offset : +9:00
                 * description : Tokyo, Seoul, Osaka, Sapporo, Yakutsk
                 */

                var offset: String? = null
                var description: String? = null
            }
        }

        class LoginBean {
            /**
             * uuid : c0d98354-3417-4c3e-a90d-a8437956e15c
             * username : angryswan702
             * password : melvin
             * salt : nrfCXo6y
             * md5 : 5d2deb7728b5a1a432b1e85029e6c68a
             * sha1 : 97bacc58401741ee832d20925c79bae7a47e42e6
             * sha256 : bcd1ba058e8c8798403053c8dfeeda8cd8f209436bb3a72a1d4e4e376a852798
             */

            var uuid: String? = null
            var username: String? = null
            var password: String? = null
            var salt: String? = null
            var md5: String? = null
            var sha1: String? = null
            var sha256: String? = null
        }

        class DobBean {
            /**
             * date : 1973-01-14T17:33:48Z
             * age : 46
             */

            var date: String? = null
            var age: Int = 0
        }

        class RegisteredBean {
            /**
             * date : 2006-08-25T02:12:26Z
             * age : 12
             */

            var date: String? = null
            var age: Int = 0
        }

        class IdBean {
            /**
             * name :
             * value : null
             */

            var name: String? = null
            var value: Any? = null
        }

        class PictureBean {
            /**
             * large : https://randomuser.me/api/portraits/men/22.jpg
             * medium : https://randomuser.me/api/portraits/med/men/22.jpg
             * thumbnail : https://randomuser.me/api/portraits/thumb/men/22.jpg
             */

            var large: String? = null
            var medium: String? = null
            var thumbnail: String? = null
        }
    }
}
