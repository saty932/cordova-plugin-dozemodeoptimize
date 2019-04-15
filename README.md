# cordova-plugin-dozemodeoptimize

if dozemode is already on you can check using isBatteryOptimizationAvalible() method. This method returns true or false.

```
 cordova.plugins.dozeoptimise.isBatteryOptimizationAvalible((data)=>{
        console.log(data);
      },(err)=>{
        console.log(err);
      });
```


if dozemode is on you can turnoff by using the method updateBatteryStatus.

```
   cordova.plugins.dozeoptimise.updateBatteryStatus((data)=>{
        console.log(data);
      },(err)=>{
        console.log(err);
      });
      
```

