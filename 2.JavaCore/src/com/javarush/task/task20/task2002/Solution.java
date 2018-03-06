package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            System.out.println(javaRush.hashCode());
            User user1 = new User();
            user1.setFirstName("Nikolay");
            user1.setLastName("Kotkin");
            user1.setBirthDate(new Date());
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            System.out.println(javaRush.hashCode());
            User user2 = new User();
            System.out.println(javaRush.hashCode());
            user2.setFirstName("Ekaterina");
            user2.setMale(false);
            user2.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject)) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            int usersLen = users.size();
            writer.write(String.valueOf(usersLen));
            writer.newLine();
            for (User user : users) {
                if (user.getFirstName() == null) {
                    writer.write("no");
                    writer.newLine();
                } else {
                    writer.write("yes");
                    writer.newLine();
                    writer.write(user.getFirstName());
                    writer.newLine();
                }
                if (user.getLastName() == null) {
                    writer.write("no");
                    writer.newLine();
                } else {
                    writer.write("yes");
                    writer.newLine();
                    writer.write(user.getLastName());
                    writer.newLine();
                }
                if (user.getBirthDate() == null) {
                    writer.write("no");
                    writer.newLine();
                } else {
                    writer.write("yes");
                    writer.newLine();
                    writer.write(String.valueOf(user.getBirthDate().getTime()));
                    writer.newLine();
                }
                writer.write(String.valueOf(user.isMale()));
                writer.newLine();
                if (user.getCountry() == null) {
                    writer.write("no");
                    writer.newLine();
                } else {
                    writer.write("yes");
                    writer.newLine();
                    writer.write(user.getCountry().toString());
                    writer.newLine();
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int usersLen = Integer.parseInt(reader.readLine());
            for (int i = 0; i < usersLen; i++) {
                User user = new User();
                if ("yes".equals(reader.readLine())) {
                    user.setFirstName(reader.readLine());
                } else {
                    user.setFirstName(null);
                }
                if ("yes".equals(reader.readLine())) {
                    user.setLastName(reader.readLine());
                } else {
                    user.setLastName(null);
                }
                if ("yes".equals(reader.readLine())) {
                    user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                } else {
                    user.setBirthDate(null);
                }
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                if ("yes".equals(reader.readLine())) {
                    String country = reader.readLine();
                    if (country.equals("RUSSIA")) {
                        user.setCountry(User.Country.RUSSIA);
                    } else if (country.equals("UKRAINE")) {
                        user.setCountry(User.Country.UKRAINE);
                    } else if (country.equals("OTHER")) {
                        user.setCountry(User.Country.OTHER);
                    }
                } else {
                    user.setCountry(null);
                }
                this.users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
