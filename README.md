# PultusRxBus [![](https://jitpack.io/v/ninja.sakib/PultusRxBus.svg)](https://jitpack.io/#ninja.sakib/PultusRxBus)

PultusRxBus is a EventBus library based on RxJava2 for Android / Java / Kotlin.

### Usages
In your build file add
##### Gradle
```gradle
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
And
```gradle
dependencies {
    compile 'ninja.sakib:PultusRxBus:beta-0.2'
}
```

##### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
	</repository>
</repositories>
```
And
```xml
<dependency>
    <groupId>ninja.sakib</groupId>
    <artifactId>PultusRxBus</artifactId>
    <version>beta-0.2</version>
</dependency>
```

In case you need jar download is available [here](https://jitpack.io/ninja/sakib/PultusRxBus/beta-0.2/PultusRxBus-beta-0.2.jar).

More option can be found [here](https://jitpack.io/#ninja.sakib/PultusRxBus/beta-0.2).

### Examples

Lets say we want to catch event for class `SampleEvent`

```java
public class SampleEvent {
    
}
```

Then implement Consumer interface to receive event,
```
public class SampleEventReceiver implements Consumer<SampleEvent> {

    @Override
    public void accept(SampleEvent event) throws Exception {
        // You will get event callback here
        
    }
}
```

Now subscribe,

```java
String consumerId = "123";
PultusRxBus.getInstance().subscribe(SampleEvent.class, consumerId, new SampleEventReceiver());
```

Finally publish,
```
PultusRxBus.getInstance().publish(new SampleEvent());
```

To unsubscribe,
```
PultusRxBus.getInstance().unsubscribe(consumerId);
```

### License
Copyright &copy;  Sakib Sami

Distributed under [MIT](https://github.com/s4kibs4mi/PultusRxBus/blob/master/LICENSE) license
