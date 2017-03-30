package Module8;


import java.util.Objects;

public class Food {
        private int id;
        private String name;
        private Country country;
        private int expiration;

        public Food(String name, Country country, int expiration) {
            this.id = IdGenerator.generateId();
            this.name = name;
            this.country = country;
            this.expiration = expiration;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Country getCountry() {
            return country;
        }

        public void setCountry(Country country) {
            this.country = country;
        }

        public int getExpiration() {
            return expiration;
        }

        public void setExpiration(int expiration) {
            this.expiration = expiration;
        }

        @Override
        public int hashCode() {;
            return Objects.hash(id);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return false;
            }
            if (!(o instanceof Food)) {
                return false;
            }
            Food food = (Food) o;
            return Objects.equals(id, food.id);
        }

        @Override
        public String toString() {
            return "Food [id=" + id + ", name=" + name + ", country=" + country + ", expiration=" + expiration + "]";
        }
}

