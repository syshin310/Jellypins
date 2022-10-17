package jellypins.org.widget.battery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_BATTERY_CHANGED
import android.content.IntentFilter
import android.os.BatteryManager.*
import androidx.lifecycle.LiveData
import java.math.RoundingMode
import java.text.DecimalFormat


/**
 * packageName    : jellypins.org.widget.battery
 * fileName       : BatteryChangedReceiver
 * author         : syshin310
 * date           : 2022-06-29
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-29       syshin310          최초 생성
 */
class BatteryInfo {
    /**
     * 배터리 현재 상태
     * 1: BATTERY_STATUS_UNKNOWN
     * 2: BATTERY_STATUS_CHARGING
     * 3: BATTERY_STATUS_DISCHARGING
     * 4: BATTERY_STATUS_NOT_CHARGING
     * 5: BATTERY_STATUS_FULL
     */
    private var status = 0

    /**
     * 배터리 Health
     * 1: BATTERY_HEALTH_UNKNOWN
     * 2: BATTERY_HEALTH_GOOD
     * 3: BATTERY_HEALTH_OVERHEAT
     * 4: BATTERY_HEALTH_DEAD
     * 5: BATTERY_HEALTH_OVER_VOLTAGE
     * 6: BATTERY_HEALTH_UNSPECIFIED_FAILURE
     * 7: BATTERY_HEALTH_COLD
     */
    private var health = 0

    /**
     * 충전 연결 상태
     * 1: 연결됨
     * 2: 연결 안됨
     */
    private var plugged = 0

    /**
     * 배터리 충전 level
     * 0~Scale
     */
    private var level = 0

    /**
     * 배터리 충전 Scale (Maximum 배터리 level)
     */
    private var scale = 0

    /**
     * 배터리 온도 (temperature/10)
     */
    private var temperature = 0

    /**
     * 충전 voltage
     */
    private var voltage = 0
    fun getStatus(): Int {
        return status
    }

    fun setStatus(status: Int) {
        this.status = status
    }

    fun getHealth(): Int {
        return health
    }

    fun setHealth(health: Int) {
        this.health = health
    }

    fun getPlugged(): Int {
        return plugged
    }

    fun setPlugged(plugged: Int) {
        this.plugged = plugged
    }

    fun getLevel(): Int {
        return level
    }

    fun setLevel(level: Int) {
        this.level = level
    }

    fun getTemperature(): Int {
        return temperature
    }

    fun setTemperature(temperature: Int) {
        this.temperature = temperature
    }

    fun getScale(): Int {
        return scale
    }

    fun setScale(scale: Int) {
        this.scale = scale
    }

    fun getVoltage(): Int {
        return voltage
    }

    fun setVoltage(voltage: Int) {
        this.voltage = voltage
    }

    /**
     * 밀리볼트 단위 취득
     * @return
     */
    fun getMilliVoltage():String {
        // convert Millivolts to Volts
        val volts = voltage * 0.001

        // initialize a new decimal format instance
        val decimalFormat = DecimalFormat("#.#")

        // round the number using decimal format
        decimalFormat.roundingMode = RoundingMode.CEILING

        // format the decimal value to one decimal position
        return decimalFormat.format(volts)
    }

    /**
     * 배터리 충전 량 (%)
     * @return
     */
    fun getPercent(): Int {
        val percent = level.toFloat() / scale
        return (percent * 100).toInt()
    }

    override fun toString(): String {
        return "BatteryInfo{" +
                "status=" + status +
                ", health=" + health +
                ", plugged=" + plugged +
                ", level=" + level +
                ", scale=" + scale +
                ", percent=" + getPercent() +
                ", temperature=" + temperature +
                ", voltage=" + voltage +
                '}'
    }
}

class BatteryChangedReceiver(val context: Context) : LiveData<BatteryInfo>() {
    val UNKNOWN = -1

    private var batteryReceiver: BroadcastReceiver? = null

    override fun onActive() {
        super.onActive()
        registerBatteryReceiver()
    }

    private fun registerBatteryReceiver() {
        if (batteryReceiver == null) {
            batteryReceiver = BatteryReceiver()
        }
        val intentFilter = IntentFilter(ACTION_BATTERY_CHANGED)
        context.registerReceiver(batteryReceiver, intentFilter)
    }

    override fun onInactive() {
        super.onInactive()
        context.unregisterReceiver(batteryReceiver)
    }

    /**
     * 배터리 상태 리시버
     */
    inner class BatteryReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            setBatteryInfo(intent)
        }
    }

    private fun setBatteryInfo(intent: Intent) {
        val status = intent.getIntExtra(EXTRA_STATUS, UNKNOWN)
        val plugged = intent.getIntExtra(EXTRA_PLUGGED, UNKNOWN)
        val health = intent.getIntExtra(EXTRA_HEALTH, UNKNOWN)
        val level = intent.getIntExtra(EXTRA_LEVEL, UNKNOWN)
        val temperature = intent.getIntExtra(EXTRA_TEMPERATURE, UNKNOWN)
        val scale = intent.getIntExtra(EXTRA_SCALE, UNKNOWN)
        val voltage = intent.getIntExtra(EXTRA_VOLTAGE, UNKNOWN)
        val info = BatteryInfo()
        info.setStatus(status)
        info.setHealth(health)
        info.setLevel(level)
        info.setPlugged(plugged)
        info.setTemperature(temperature)
        info.setScale(scale)
        info.setVoltage(voltage)
        value = info
    }
}
