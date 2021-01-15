# java-swing-notas

This project using Gradle.

## Prerequisites 🔨

1. Install Windows 10
2. Install gradle-6.4.1
3. Install Java version 1.8.0_201
4. Install postgres:10
5. Optional install docker
6. Optional Clients: HeidiSQ, Dbeaver

Note: resolution recomented: 1920x1080

### Optional install postgres db in docker

```
docker pull postgres:10
docker run -d --name postgresdb -e POSTGRES_PASSWORD=secret123 -p 5432:5432 postgres:10
default user: postgres
default dbname: postgres
password: secret123
```

## Deploy / Installation 🔧

1. gradlew build

2. Execute all the queries in sql folder in your data bases.

- Create data bases.
- Create tables.
- Note: you should create a tables in public schema.

3. Config config.properties file.
4. java -jar build/libs/java-swing-notas.jar

## Diagrams

### Class Diagram

<p align="center">
  <img src="documentation/class-diagram.jpg">
</p>

### Use Case Diagram

<p align="center">
  <img src="documentation/use-case-diagram.jpg">
</p>

### Use Case Diagram Detailed

<p align="center">
  <img src="documentation/use-case-diagram-detailed.jpg">
</p>

### Entity Relation Data Base

<p align="center">
  <img src="documentation/diagram-database-dbeaver.jpg">
</p>

### Entity Relation Chen Notation Diagram

<p align="center">
  <img src="documentation/entity-relation-notation-chen.jpg">
</p>

### Entity Relation Crows Foot Diagram

<p align="center">
  <img src="documentation/entity-relation-crows-foot.jpg">
</p>

## UI Screens

### Login

<p align="center">
  <img src="documentation/ui-login.jpg">
</p>

### Users

<p align="center">
  <img src="documentation/ui-users-modal.jpg">
</p>

<p align="center">
  <img src="documentation/ui-users-table.jpg">
</p>

### Students

<p align="center">
  <img src="documentation/ui-students-modal.jpg">
</p>

<p align="center">
  <img src="documentation/ui-students-table.jpg">
</p>

### Courses

<p align="center">
  <img src="documentation/ui-courses-modal.jpg">
</p>

<p align="center">
  <img src="documentation/ui-courses-table.jpg">
</p>

### Subjects

<p align="center">
  <img src="documentation/ui-subjects-modal.jpg">
</p>

<p align="center">
  <img src="documentation/ui-subjects-table.jpg">
</p>

### Study Plan

<p align="center">
  <img src="documentation/ui-plan-registrar-curso-modal.jpg">
</p>

<p align="center">
  <img src="documentation/ui-plan-registrar-materia.jpg">
</p>

<p align="center">
  <img src="documentation/ui-plan-mostrar-materia.jpg">
</p>

### Inscriptions

<p align="center">
  <img src="documentation/ui-inscripciones-registrar-curso.jpg">
</p>

<p align="center">
  <img src="documentation/ui-inscripciones-registrar-estudiante.jpg">
</p>

<p align="center">
  <img src="documentation/ui-inscripciones-mostrar-estudiante.jpg">
</p>

### Notes

<p align="center">
  <img src="documentation/ui-notas-registrar-mostrar-curso.jpg">
</p>

<p align="center">
  <img src="documentation/ui-notas-registrar-mostrar-estudiante.jpg">
</p>

<p align="center">
  <img src="documentation/ui-notas-registrar-mostrar-materia.jpg">
</p>

### Reports

### Reports By Course

<p align="center">
  <img src="documentation/ui-reporte-notas-curso-curso.jpg">
</p>

<p align="center">
  <img src="documentation/ui-reporte-notas-curso-estudiante.jpg">
</p>

<p align="center">
  <img src="documentation/ui-reporte-notas-curso-materia.jpg">
</p>

### Reports By Student

<p align="center">
  <img src="documentation/ui-reporte-notas-estudiante-estudiante.jpg">
</p>

<p align="center">
  <img src="documentation/ui-reporte-notas-estudiante-curso.jpg">
</p>

<p align="center">
  <img src="documentation/ui-reporte-notas-estudiante-materia.jpg">
</p>

## Contributing 🖇️

1. Fork it!
2. Create your feature branch: `git checkout -b feature/1001`
3. Commit your changes: `git commit -m 'feature/1001: Add some feature'`
4. Push to the branch: `git push origin feature/1001`
5. Submit a pull request.

## License 📄

- Free.
