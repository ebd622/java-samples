


# Containerize java app with JIB plugin
This is a simple example on how to use [Jib](https://github.com/GoogleContainerTools/jib) in your project.

## Quick start

### Build an image as a tar
Build and save an image to disk as a tar-file (tarball)

(No Docker needed running in your environment)

```
mvn compile jib:buildTar
```
After this you can move a docker-image (as a tar-file) from one environment/computer to another one.

### Build to Docker daemon
Jib can build an image directly to a Docker daemon (docker needs to be running in your env):
```
mvn compile jib:dockerBuild
```

### Build an image and push to Docker Hub
Before pushing an image to  Docker Hub make sure you have a correct configuration in `pom.xml`:

```
<configuration>
  <to>
    <image>docker.io/my-docker-id/my-app</image>
  </to>
</configuration>
```

Run the command to build and push the image:
```
mvn compile jib:build
```

## Resources
* Jib: https://github.com/GoogleContainerTools/jib
