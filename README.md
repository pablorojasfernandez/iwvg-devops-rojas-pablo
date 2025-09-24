## [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
## Ingeniería Web: Visión General (IWVG) DevOps

#### Project by Pablo Rojas Fernández

### Code status
[![DevOps](https://github.com/pablorojasfernandez/iwvg-devops-rojas-pablo/actions/workflows/continuous-integration.yml/badge.svg)](https://github.com/pablorojasfernandez/iwvg-devops-rojas-pablo/actions/workflows/continuous-integration.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=pablorojasfernandez_iwvg-devops-rojas-pablo&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=pablorojasfernandez_iwvg-devops-rojas-pablo)
[![Render broken](https://iwvg-devops-rojas-pablo.onrender.com/version-badge)](https://iwvg-devops-rojas-pablo.onrender.com/swagger-ui.html)

### Required technologies
`Java` `Maven` `GitHub` `GitHub Actions` `Sonarcloud` `Slack` `Spring-Boot` `GitHub Packages` `Docker` `OpenAPI`

### :gear: Project installation
1. Clone the repository on your computer using the **console**:
```sh
cd <folder path>
git clone https://github.com/pablorojasfernandez/iwvg-devops-rojas-pablo
```
2. Import the project using **IntelliJ IDEA**
   * **Open**, and select the project folder.

### :gear: Local execution with IntelliJ
* Run the **Application** class with IntelliJ

### :gear: Local execution with Docker
* Create the network, only once:
```sh
docker network create devopsNet
```
* View networks:
```sh
docker network ls
```
* Docker command to create image and start container with image (⚠️ include the **end point**):
```sh
docker build -t devops:latest .
docker run -d --name devops1  -p 8080:8080 devops
```

* Command to create image and start it in container using docker compose (uses the **docker-compose.yml**)
```sh
docker compose up --build -d
```

* Web Client: `http://localhost:8080`


### Tasks completed in Sprint 3
The last commit before starting this sprint was [commit #14108dd](https://github.com/pablorojasfernandez/iwvg-devops-rojas-pablo/commit/14108ddf4a7ae25512cba96d590541b3baed6d54).

* `0` Stream&lt;String> findUserFamilyNameInitialBySomeProperFraction();
* `1` Stream&lt;String> findUserIdBySomeProperFraction();
* `4` Double findFirstDecimalFractionByUserName(String name);
* `8` Stream&lt;String> findUserFamilyNameBySomeImproperFraction();

### Bug task
The method was correct, so what I did is to put a comment in the method `4` ***Double findFirstDecimalFractionByUserName(String name);*** to say that the bug is fixed.

### Fractions with denominator zero
While doing the exercise, I realised that fractions cannot have a denominator of zero. This caused a modification in the `UsersDatabase` class, removing two fractions with a denominator = 0 from the code.

I asked the teacher, and there is no problem with removing these fractions, because the exercise is about **devops**.

<details>
<summary>The code looks like this:</summary>

```ruby
List<Fraction> fractions6 = List.of(
        //new Fraction(0, 0),
        //new Fraction(1, 0),
        new Fraction(1, 1)
);
```

</details>

### Problems detected with Unit Tests:
Initially, coverage results from unit tests were not reported in SonarCloud, even though the tests were executed successfully.

The Maven configuration was overriding the argLine property, replacing Jacoco’s agent with Mockito’s one.
```
<configuration>
    <argLine>
        -javaagent:${settings.localRepository}/org/mockito/mockito-core/${mockito.version}/mockito-core-${mockito.version}.jar
        -Xshare:off
    </argLine>
</configuration>
```
As a result, no coverage was sent to SonarCloud.

Updated the ***maven-surefire-plugin*** configuration to append our custom arguments:
```
<configuration>
    <argLine>${argLine} -Xshare:off</argLine>
</configuration>
```
SonarCloud correctly reports test coverage.