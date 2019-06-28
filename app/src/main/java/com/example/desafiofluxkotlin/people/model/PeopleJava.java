package com.example.desafiofluxkotlin.people.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class PeopleJava implements Parcelable {

    /**
     * results : [{"gender":"male","name":{"title":"mr","first":"gordon","last":"hamilton"},"location":{"street":"3111 queen street","city":"salford","state":"greater manchester","postcode":"GJ74 3WS","coordinates":{"latitude":"15.1436","longitude":"-165.4709"},"timezone":{"offset":"-3:30","description":"Newfoundland"}},"email":"gordon.hamilton@example.com","login":{"uuid":"6554ab66-322a-44db-92b0-7849d5e1278a","username":"sadbear521","password":"bondage","salt":"nijPqYT2","md5":"b6d7609e04e6c626703317e1a8c92812","sha1":"d39101e7effc1949ad365183ffb8a756843cd265","sha256":"f9a7772eb4a67a2de6d815440e098cda2d4c9bcc224f8f485bbf185bd3843cc6"},"dob":{"date":"1972-12-04T07:41:57Z","age":46},"registered":{"date":"2006-10-05T17:37:07Z","age":12},"phone":"013873 99949","cell":"0756-900-412","id":{"name":"NINO","value":"LH 07 79 45 H"},"picture":{"large":"https://randomuser.me/api/portraits/men/57.jpg","medium":"https://randomuser.me/api/portraits/med/men/57.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/men/57.jpg"},"nat":"GB"}]
     * info : {"seed":"b0b56ded400c0f51","results":1,"page":1,"version":"1.2"}
     */

    private InfoBean info;
    private List<ResultsBean> results;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class InfoBean implements Parcelable {
        /**
         * seed : b0b56ded400c0f51
         * results : 1
         * page : 1
         * version : 1.2
         */

        private String seed;
        private int results;
        private int page;
        private String version;

        public String getSeed() {
            return seed;
        }

        public void setSeed(String seed) {
            this.seed = seed;
        }

        public int getResults() {
            return results;
        }

        public void setResults(int results) {
            this.results = results;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.seed);
            dest.writeInt(this.results);
            dest.writeInt(this.page);
            dest.writeString(this.version);
        }

        public InfoBean() {
        }

        protected InfoBean(Parcel in) {
            this.seed = in.readString();
            this.results = in.readInt();
            this.page = in.readInt();
            this.version = in.readString();
        }

        public static final Creator<InfoBean> CREATOR = new Creator<InfoBean>() {
            @Override
            public InfoBean createFromParcel(Parcel source) {
                return new InfoBean(source);
            }

            @Override
            public InfoBean[] newArray(int size) {
                return new InfoBean[size];
            }
        };
    }

    public static class ResultsBean implements Parcelable {
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

        private String gender;
        private NameBean name;
        private LocationBean location;
        private String email;
        private LoginBean login;
        private DobBean dob;
        private RegisteredBean registered;
        private String phone;
        private String cell;
        private IdBean id;
        private PictureBean picture;
        private String nat;

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public NameBean getName() {
            return name;
        }

        public void setName(NameBean name) {
            this.name = name;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public LoginBean getLogin() {
            return login;
        }

        public void setLogin(LoginBean login) {
            this.login = login;
        }

        public DobBean getDob() {
            return dob;
        }

        public void setDob(DobBean dob) {
            this.dob = dob;
        }

        public RegisteredBean getRegistered() {
            return registered;
        }

        public void setRegistered(RegisteredBean registered) {
            this.registered = registered;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCell() {
            return cell;
        }

        public void setCell(String cell) {
            this.cell = cell;
        }

        public IdBean getId() {
            return id;
        }

        public void setId(IdBean id) {
            this.id = id;
        }

        public PictureBean getPicture() {
            return picture;
        }

        public void setPicture(PictureBean picture) {
            this.picture = picture;
        }

        public String getNat() {
            return nat;
        }

        public void setNat(String nat) {
            this.nat = nat;
        }

        public static class NameBean implements Parcelable {
            /**
             * title : mr
             * first : gordon
             * last : hamilton
             */

            private String title;
            private String first;
            private String last;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getFirst() {
                return first;
            }

            public void setFirst(String first) {
                this.first = first;
            }

            public String getLast() {
                return last;
            }

            public void setLast(String last) {
                this.last = last;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.title);
                dest.writeString(this.first);
                dest.writeString(this.last);
            }

            public NameBean() {
            }

            protected NameBean(Parcel in) {
                this.title = in.readString();
                this.first = in.readString();
                this.last = in.readString();
            }

            public static final Creator<NameBean> CREATOR = new Creator<NameBean>() {
                @Override
                public NameBean createFromParcel(Parcel source) {
                    return new NameBean(source);
                }

                @Override
                public NameBean[] newArray(int size) {
                    return new NameBean[size];
                }
            };
        }

        public static class LocationBean implements Parcelable {
            /**
             * street : 3111 queen street
             * city : salford
             * state : greater manchester
             * postcode : GJ74 3WS
             * coordinates : {"latitude":"15.1436","longitude":"-165.4709"}
             * timezone : {"offset":"-3:30","description":"Newfoundland"}
             */

            private String street;
            private String city;
            private String state;
            private String postcode;
            private CoordinatesBean coordinates;
            private TimezoneBean timezone;

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getPostcode() {
                return postcode;
            }

            public void setPostcode(String postcode) {
                this.postcode = postcode;
            }

            public CoordinatesBean getCoordinates() {
                return coordinates;
            }

            public void setCoordinates(CoordinatesBean coordinates) {
                this.coordinates = coordinates;
            }

            public TimezoneBean getTimezone() {
                return timezone;
            }

            public void setTimezone(TimezoneBean timezone) {
                this.timezone = timezone;
            }

            public static class CoordinatesBean implements Parcelable {
                /**
                 * latitude : 15.1436
                 * longitude : -165.4709
                 */

                private String latitude;
                private String longitude;

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.latitude);
                    dest.writeString(this.longitude);
                }

                public CoordinatesBean() {
                }

                protected CoordinatesBean(Parcel in) {
                    this.latitude = in.readString();
                    this.longitude = in.readString();
                }

                public static final Creator<CoordinatesBean> CREATOR = new Creator<CoordinatesBean>() {
                    @Override
                    public CoordinatesBean createFromParcel(Parcel source) {
                        return new CoordinatesBean(source);
                    }

                    @Override
                    public CoordinatesBean[] newArray(int size) {
                        return new CoordinatesBean[size];
                    }
                };
            }

            public static class TimezoneBean implements Parcelable {
                /**
                 * offset : -3:30
                 * description : Newfoundland
                 */

                private String offset;
                private String description;

                public String getOffset() {
                    return offset;
                }

                public void setOffset(String offset) {
                    this.offset = offset;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.offset);
                    dest.writeString(this.description);
                }

                public TimezoneBean() {
                }

                protected TimezoneBean(Parcel in) {
                    this.offset = in.readString();
                    this.description = in.readString();
                }

                public static final Creator<TimezoneBean> CREATOR = new Creator<TimezoneBean>() {
                    @Override
                    public TimezoneBean createFromParcel(Parcel source) {
                        return new TimezoneBean(source);
                    }

                    @Override
                    public TimezoneBean[] newArray(int size) {
                        return new TimezoneBean[size];
                    }
                };
            }

            public LocationBean() {
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.street);
                dest.writeString(this.city);
                dest.writeString(this.state);
                dest.writeString(this.postcode);
                dest.writeParcelable(this.coordinates, flags);
                dest.writeParcelable(this.timezone, flags);
            }

            protected LocationBean(Parcel in) {
                this.street = in.readString();
                this.city = in.readString();
                this.state = in.readString();
                this.postcode = in.readString();
                this.coordinates = in.readParcelable(CoordinatesBean.class.getClassLoader());
                this.timezone = in.readParcelable(TimezoneBean.class.getClassLoader());
            }

            public static final Creator<LocationBean> CREATOR = new Creator<LocationBean>() {
                @Override
                public LocationBean createFromParcel(Parcel source) {
                    return new LocationBean(source);
                }

                @Override
                public LocationBean[] newArray(int size) {
                    return new LocationBean[size];
                }
            };
        }

        public static class LoginBean implements Parcelable {
            /**
             * uuid : 6554ab66-322a-44db-92b0-7849d5e1278a
             * username : sadbear521
             * password : bondage
             * salt : nijPqYT2
             * md5 : b6d7609e04e6c626703317e1a8c92812
             * sha1 : d39101e7effc1949ad365183ffb8a756843cd265
             * sha256 : f9a7772eb4a67a2de6d815440e098cda2d4c9bcc224f8f485bbf185bd3843cc6
             */

            private String uuid;
            private String username;
            private String password;
            private String salt;
            private String md5;
            private String sha1;
            private String sha256;

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getSalt() {
                return salt;
            }

            public void setSalt(String salt) {
                this.salt = salt;
            }

            public String getMd5() {
                return md5;
            }

            public void setMd5(String md5) {
                this.md5 = md5;
            }

            public String getSha1() {
                return sha1;
            }

            public void setSha1(String sha1) {
                this.sha1 = sha1;
            }

            public String getSha256() {
                return sha256;
            }

            public void setSha256(String sha256) {
                this.sha256 = sha256;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.uuid);
                dest.writeString(this.username);
                dest.writeString(this.password);
                dest.writeString(this.salt);
                dest.writeString(this.md5);
                dest.writeString(this.sha1);
                dest.writeString(this.sha256);
            }

            public LoginBean() {
            }

            protected LoginBean(Parcel in) {
                this.uuid = in.readString();
                this.username = in.readString();
                this.password = in.readString();
                this.salt = in.readString();
                this.md5 = in.readString();
                this.sha1 = in.readString();
                this.sha256 = in.readString();
            }

            public static final Creator<LoginBean> CREATOR = new Creator<LoginBean>() {
                @Override
                public LoginBean createFromParcel(Parcel source) {
                    return new LoginBean(source);
                }

                @Override
                public LoginBean[] newArray(int size) {
                    return new LoginBean[size];
                }
            };
        }

        public static class DobBean implements Parcelable {
            /**
             * date : 1972-12-04T07:41:57Z
             * age : 46
             */

            private String date;
            private int age;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.date);
                dest.writeInt(this.age);
            }

            public DobBean() {
            }

            protected DobBean(Parcel in) {
                this.date = in.readString();
                this.age = in.readInt();
            }

            public static final Creator<DobBean> CREATOR = new Creator<DobBean>() {
                @Override
                public DobBean createFromParcel(Parcel source) {
                    return new DobBean(source);
                }

                @Override
                public DobBean[] newArray(int size) {
                    return new DobBean[size];
                }
            };
        }

        public static class RegisteredBean implements Parcelable {
            /**
             * date : 2006-10-05T17:37:07Z
             * age : 12
             */

            private String date;
            private int age;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.date);
                dest.writeInt(this.age);
            }

            public RegisteredBean() {
            }

            protected RegisteredBean(Parcel in) {
                this.date = in.readString();
                this.age = in.readInt();
            }

            public static final Creator<RegisteredBean> CREATOR = new Creator<RegisteredBean>() {
                @Override
                public RegisteredBean createFromParcel(Parcel source) {
                    return new RegisteredBean(source);
                }

                @Override
                public RegisteredBean[] newArray(int size) {
                    return new RegisteredBean[size];
                }
            };
        }

        public static class IdBean implements Parcelable {
            /**
             * name : NINO
             * value : LH 07 79 45 H
             */

            private String name;
            private String value;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.name);
                dest.writeString(this.value);
            }

            public IdBean() {
            }

            protected IdBean(Parcel in) {
                this.name = in.readString();
                this.value = in.readString();
            }

            public static final Creator<IdBean> CREATOR = new Creator<IdBean>() {
                @Override
                public IdBean createFromParcel(Parcel source) {
                    return new IdBean(source);
                }

                @Override
                public IdBean[] newArray(int size) {
                    return new IdBean[size];
                }
            };
        }

        public static class PictureBean implements Parcelable {
            /**
             * large : https://randomuser.me/api/portraits/men/57.jpg
             * medium : https://randomuser.me/api/portraits/med/men/57.jpg
             * thumbnail : https://randomuser.me/api/portraits/thumb/men/57.jpg
             */

            private String large;
            private String medium;
            private String thumbnail;

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.large);
                dest.writeString(this.medium);
                dest.writeString(this.thumbnail);
            }

            public PictureBean() {
            }

            protected PictureBean(Parcel in) {
                this.large = in.readString();
                this.medium = in.readString();
                this.thumbnail = in.readString();
            }

            public static final Creator<PictureBean> CREATOR = new Creator<PictureBean>() {
                @Override
                public PictureBean createFromParcel(Parcel source) {
                    return new PictureBean(source);
                }

                @Override
                public PictureBean[] newArray(int size) {
                    return new PictureBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.gender);
            dest.writeParcelable(this.name, flags);
            dest.writeParcelable(this.location, flags);
            dest.writeString(this.email);
            dest.writeParcelable(this.login, flags);
            dest.writeParcelable(this.dob, flags);
            dest.writeParcelable(this.registered, flags);
            dest.writeString(this.phone);
            dest.writeString(this.cell);
            dest.writeParcelable(this.id, flags);
            dest.writeParcelable(this.picture, flags);
            dest.writeString(this.nat);
        }

        public ResultsBean() {
        }

        protected ResultsBean(Parcel in) {
            this.gender = in.readString();
            this.name = in.readParcelable(NameBean.class.getClassLoader());
            this.location = in.readParcelable(LocationBean.class.getClassLoader());
            this.email = in.readString();
            this.login = in.readParcelable(LoginBean.class.getClassLoader());
            this.dob = in.readParcelable(DobBean.class.getClassLoader());
            this.registered = in.readParcelable(RegisteredBean.class.getClassLoader());
            this.phone = in.readString();
            this.cell = in.readString();
            this.id = in.readParcelable(IdBean.class.getClassLoader());
            this.picture = in.readParcelable(PictureBean.class.getClassLoader());
            this.nat = in.readString();
        }

        public static final Creator<ResultsBean> CREATOR = new Creator<ResultsBean>() {
            @Override
            public ResultsBean createFromParcel(Parcel source) {
                return new ResultsBean(source);
            }

            @Override
            public ResultsBean[] newArray(int size) {
                return new ResultsBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.info, flags);
        dest.writeList(this.results);
    }

    public PeopleJava() {
    }

    protected PeopleJava(Parcel in) {
        this.info = in.readParcelable(InfoBean.class.getClassLoader());
        this.results = new ArrayList<ResultsBean>();
        in.readList(this.results, ResultsBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<People> CREATOR = new Parcelable.Creator<People>() {
        @Override
        public People createFromParcel(Parcel source) {
            return new People(source);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };
}
