package models;


    public enum SectionsEnum {
        ENGLISH("english"),
        GERMAN("german");
        private String value;
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        SectionsEnum(String value) {
            this.value = value;
    }


    }

