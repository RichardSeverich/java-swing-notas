# Java notas

Notas.

## Prerequisites 🚀

1. Install Windows 10
2. Install Java version 1.8.0_201
3. Install postgres:10
4. Optional docker:

```
docker pull postgres:10
docker run -d --name postgresdb -e POSTGRES_PASSWORD=secret123 -p 5432:5432 postgres:10
default user: postgres
default dbname: postgres
password: secret123
```

5. Optional Clients: HeidiSQ, Dbeaver

Note: resolution recomented: 1920x1080

## Deploy / Installation 🔧

1. gradlew build
2. execute all the queries in sql folder.
   note: you shoudl create a data in public schema.
3. java -jar build/libs/java-swing-notas.jar

## Screens

<p align="center">
  <img src="documentation/someimage.jpg">
</p>

## Contributing 🖇️

1. Fork it!
2. Create your feature branch: `git checkout -b feature/1001`
3. Commit your changes: `git commit -m 'feature/1001: Add some feature'`
4. Push to the branch: `git push origin feature/1001`
5. Submit a pull request.

## License 📄

- Free.
