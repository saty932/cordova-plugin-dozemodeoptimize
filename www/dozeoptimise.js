var exec = require('cordova/exec');

exports.isBatteryOptimizationAvalible = function (success, error) {
	exec(success, error, 'dozeoptimise', 'isBatteryOptimizationAvalible',[]);
};

exports.updateBatteryStatus= function (success, error) {
	exec(success, error, 'dozeoptimise', 'updateBatteryStatus',[]);
};
