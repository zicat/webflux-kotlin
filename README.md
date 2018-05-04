# Prepare
    Install JDK 8+
    Install newest maven
    Install git command
    check environment is ready
    $ java -version
      java version "1.8.0_144"
      Java(TM) SE Runtime Environment (build 1.8.0_144-b01)
      Java HotSpot(TM) 64-Bit Server VM (build 25.144-b01, mixed mode)  
    $ mvn -version
      Apache Maven 3.5.0
    $ git --version
      git version 2.14.1

# Start build webflux-kotlin
    1. $ git clone https://github.com/zicat/webflux-kotlin.git
    2. $ cd webflux-kotlin
    3. $ mvn clean install
    4. $ mvn spring-boot:run
    5. open broser and input url
       http://localhost:8080/product?productId=1&description=a
Your first webflux-kotlin restfull api is finished!

# Create webflux-kotlin maven archetype
    1. $ cd webflux-kotlin
    2. $ mvn archetype:create-from-project
    3. $ cd target/generated-sources/archetype
    4. $ mvn install

# Create your restfull api project with maven archetype
    1. $ cd your work dir
    2. $ mvn archetype:generate \
        -DarchetypeGroupId=name.zicat \
        -DarchetypeArtifactId=webflux-kotlin-archetype \
        -DarchetypeVersion=1.0-SNAPSHOT \
        -DgroupId=${your_group_id} \
        -DartifactId=${your_artifact_id} \
        -Dversion=${your_version}
    3. $ cd ${your_artifact_id}
    4. $ mvn clean install
    5. $ mvn spring-boot:run
    6. open broser and input url
        http://localhost:8080/product?productId=1&description=a

# Start Coding
    1. download intellij 15+
    2. import ${your_artifact_id} to intellij
         
