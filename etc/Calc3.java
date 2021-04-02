package com.doosan.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.doosan.test.JnaUnisteam.UniSteamCal;

public class Calc3 {
	// batch 백업
	private static Function<List<Object>, Object> popStack = stack -> stack.remove(stack.size() - 1);
	
	public static void main(String[] args) {
		List<Object> stack = new ArrayList();
		double F6 = 0.044522, F7 = 138.0, F8 = 573.5359, F9 = 86.0846, F10 = 33.9033, F11 = 374.6436, F12 = 31.6, F13 = 584.3, F14 = 97.369, F15 = 3.5995, F16 = 256.6964, F17 = 8.3830, F18 = 106.3139, F19 = 146.6;
//
//		stack.add(F6);
//		stack.add(F7);
//		stack.add(F8);
//		stack.add(F9);
//		stack.add(F10);
//		stack.add(F11);
//		stack.add(F12);
//		stack.add(F13);
//		stack.add(F14);
//		stack.add(F15);
//		stack.add(F16);
//		stack.add(F17);
//		stack.add(F18);
//		stack.add(F19);
//		System.out.println(st_energy_in.apply(stack)); // 407.07
//		System.out.println(st_efficiency.apply(stack)); // 36.01
		double G3 =2.5516328 
, G5 = 24.2283607 
, G7 = 20.3975559 
, G8 = 27.8799087 
, G9 = 0.0397797 
, G10 = 141.2980374 
, G11 = 574.8329444 
, G12 = 88.5859843 
, G13 = 34.7526730 
, G14 = 374.6637500 
, G15 = 32.2686344 
, G16 = 581.4560869 
, G17 = 99.7087903 
, G18 = 3.5993939 
, G19 = 256.9000000 
, G20 = 9.0780124 
, G21 = 109.2919509 
, G22 = 0.0035752 
, G23 = 153.7523168 
;

//		stack.add(G3);
//		stack.add(G5);
//		stack.add(G7);
//		stack.add(G8);
		stack.add(G9);
		stack.add(G10);
		stack.add(G11);
		stack.add(G12);
		stack.add(G13);
		stack.add(G14);
		stack.add(G15);
		stack.add(G16);
		stack.add(G17);
		stack.add(G18);
		stack.add(G19);
		stack.add(G20);
		stack.add(G21);
		stack.add(G22);
		stack.add(G23);
//		System.out.println("cond_p : " + cond_p.apply(stack));
//		System.out.println("cond_sat_t : " + cond_sat_t.apply(stack));
//		System.out.println("ttd : " + ttd.apply(stack));
//		System.out.println("itd : " + itd.apply(stack));
//		System.out.println("cw_t_rise : " + cw_t_rise.apply(stack));
//		System.out.println("st_ueep : " + st_ueep.apply(stack));
//		System.out.println("condensate_water_h : " + condensate_water_h.apply(stack)); // TODO 값이 다름
//		System.out.println("condensate_water_f : " + condensate_water_f.apply(stack));
//		System.out.println("condenser_heat_load : " + condenser_heat_load.apply(stack)); // TODO 값이 다름
//		System.out.println("cond_cleanliness : " + cond_cleanliness.apply(stack)); // TODO 값이 다름
		
	}
	 // TODO 모든 시트 계산식에는 tag값을 받아 다른 엑셀의 계산식을 통해 값을 전달하는 것이 있음
    // 1CC gross_power
    // 1CC 1번
    private static Function<List<Object>, Double>  gross_power = stack -> {
        // TODO 타엑셀
        Double lhv = (Double) popStack.apply(stack), isopentane = (Double) popStack.apply(stack), pentane = (Double) popStack.apply(stack), isobutane = (Double) popStack.apply(stack), butane = (Double) popStack.apply(stack);
        Double propane = (Double) popStack.apply(stack), ethane = (Double) popStack.apply(stack), methane = (Double) popStack.apply(stack), stFrequency = (Double) popStack.apply(stack), gtPowerFactor = (Double) popStack.apply(stack);
        Double stGrossPower = (Double) popStack.apply(stack), gtGrossPowerTag = (Double) popStack.apply(stack), gasT = (Double) popStack.apply(stack), stCondenserP = (Double) popStack.apply(stack), compPin = (Double) popStack.apply(stack);
        Double compTin = (Double) popStack.apply(stack), ambientRH = (Double) popStack.apply(stack), ambientP = (Double) popStack.apply(stack), ambientT = (Double) popStack.apply(stack);
        double grossPower = (gtGrossPowerTag + stGrossPower + pAdditiveCorrection(gtGrossPowerTag, stGrossPower, gtPowerFactor) / 1000) * pPowerCorrectionProduct(ambientT, ambientP, ambientRH, compTin, compPin, stCondenserP, gasT, stFrequency, methane, ethane, propane, butane, isobutane, pentane, isopentane, lhv);
        return changeRound(grossPower);
    };

    // 1CC 2번
    private static Function<List<Object>, Double> net_power = stack -> {
        // TODO 타엑셀
        Double lhv = (Double) popStack.apply(stack), isopentane = (Double) popStack.apply(stack), pentane = (Double) popStack.apply(stack), isobutane = (Double) popStack.apply(stack), butane = (Double) popStack.apply(stack);
        Double propane = (Double) popStack.apply(stack), ethane = (Double) popStack.apply(stack), methane = (Double) popStack.apply(stack), stFrequency = (Double) popStack.apply(stack), gtPowerFactor = (Double) popStack.apply(stack);
        Double elNetPower = (Double) popStack.apply(stack), stGrossPower = (Double) popStack.apply(stack), gtGrossPowerTag = (Double) popStack.apply(stack), gasT = (Double) popStack.apply(stack), stCondenserP = (Double) popStack.apply(stack);
        Double compPin = (Double) popStack.apply(stack), compTin = (Double) popStack.apply(stack), ambientRH = (Double) popStack.apply(stack), ambientP = (Double) popStack.apply(stack), ambientT = (Double) popStack.apply(stack);
        double netPower = (elNetPower + pAdditiveCorrection(gtGrossPowerTag, stGrossPower, gtPowerFactor) / 1000) * pPowerCorrectionProduct(ambientT, ambientP, ambientRH, compTin, compPin, stCondenserP, gasT, stFrequency, methane, ethane, propane, butane, isobutane, pentane, isopentane, lhv);
        return changeRound(netPower);
    };

    // 1CC 3번
    private static Function<List<Object>, Double> gross_efficiency = stack -> {
        // TODO 타엑셀
        Double gtDensity = (Double) popStack.apply(stack), reynoldsNumber = (Double) popStack.apply(stack), hhv = (Double) popStack.apply(stack), stFrequency = (Double) popStack.apply(stack), gtPowerFactor = (Double) popStack.apply(stack);
        Double stGrossPower = (Double) popStack.apply(stack), gtGrossPowerTag = (Double) popStack.apply(stack), gasT = (Double) popStack.apply(stack), gasFlowRate = (Double) popStack.apply(stack), stCondenserP = (Double) popStack.apply(stack);
        Double compPin = (Double) popStack.apply(stack), compTin = (Double) popStack.apply(stack), ambientRH = (Double) popStack.apply(stack), ambientP = (Double) popStack.apply(stack), ambientT = (Double) popStack.apply(stack);
        double grossEfficiency = (gtGrossPowerTag + stGrossPower + pAdditiveCorrection(gtGrossPowerTag, stGrossPower, gtPowerFactor) / 1000) / (gtMassFlow(gasFlowRate, reynoldsNumber, gtDensity) / 3600 * hhv / 1000) * hrCorrectionProduct(ambientT, ambientP, ambientRH, compTin, compPin, stCondenserP, gasT, stFrequency);
        return changeRound(grossEfficiency * 100);
    };

    // 1CC 4번
    private static Function<List<Object>, Double> net_efficiency = stack -> {
        // TODO 타엑셀
        Double gtDensity = (Double) popStack.apply(stack), reynoldsNumber = (Double) popStack.apply(stack), hhv = (Double) popStack.apply(stack), stFrequency = (Double) popStack.apply(stack), gtPowerFactor = (Double) popStack.apply(stack);
        Double elnetPower = (Double) popStack.apply(stack), stGrossPower = (Double) popStack.apply(stack), gtGrossPowerTag = (Double) popStack.apply(stack), gasT = (Double) popStack.apply(stack), gasFlowRate = (Double) popStack.apply(stack);
        Double stCondenserP = (Double) popStack.apply(stack), compPin = (Double) popStack.apply(stack), compTin = (Double) popStack.apply(stack), ambientRH = (Double) popStack.apply(stack), ambientP = (Double) popStack.apply(stack);
        Double ambientT = (Double) popStack.apply(stack);
        double netEfficiency = (elnetPower + pAdditiveCorrection(gtGrossPowerTag, stGrossPower, gtPowerFactor) / 1000) / (gtMassFlow(gasFlowRate, reynoldsNumber, gtDensity) / 3600 * hhv / 1000) * hrCorrectionProduct(ambientT, ambientP, ambientRH, compTin, compPin, stCondenserP, gasT, stFrequency);
        return changeRound(netEfficiency * 100);
    };

    // 1CC 5번
    private static Function<List<Object>, Double> gt_gross_power = stack -> {
        // TODO 타엑셀
        Double lhv = (Double) popStack.apply(stack), isopentane = (Double) popStack.apply(stack), pentane = (Double) popStack.apply(stack), isobutane = (Double) popStack.apply(stack), butane = (Double) popStack.apply(stack);
        Double propane = (Double) popStack.apply(stack), ethane = (Double) popStack.apply(stack), methane = (Double) popStack.apply(stack), stFrequency = (Double) popStack.apply(stack), gtGrossPowerTag = (Double) popStack.apply(stack);
        Double gtEBH = (Double) popStack.apply(stack), gtExhaustPress = (Double) popStack.apply(stack), compPin = (Double) popStack.apply(stack), compTin = (Double) popStack.apply(stack), ambientRH = (Double) popStack.apply(stack);
        Double ambientP = (Double) popStack.apply(stack), ambientT = (Double) popStack.apply(stack);
        double ambP = -0.00809296 * Math.pow((0.001 * ambientP), 2) + 1.02802 * (0.001 * ambientP) - 0.0330795;
        double gtFilterDP = ambientP - compPin;
        double gtCompInletPLoss = -0.00129716 * (gtFilterDP) + 1.01038;
        double gtCompInletT;
        if (compTin < 15) {
            gtCompInletT = -0.00000101272 * Math.pow(compTin, 3) - 0.0000216136 * Math.pow(compTin, 2) - 0.00283226 * (compTin) + 1.05076;
        } else {
            gtCompInletT = -0.000000899352 * Math.pow(compTin, 3) + 0.00000117656 * Math.pow(compTin, 2) - 0.00445136 * (compTin) + 1.06954;
        }
        double pRelHumidity;
        double pRelEngineSpeed;
        double pRelHumidityTestX = ambientT;
        double pRelEngineSpeedTestX = ambientT;
        if(ambientT < 0) {
            pRelHumidity = -0.000000935858 * Math.pow((0.01 * ambientRH), 3) - 0.0000141332 * Math.pow((0.01 * ambientRH), 2) + 0.00381307 * (0.01 * ambientRH) + 0.997717;
            pRelEngineSpeed = 174.706 * Math.pow((stFrequency / 60), 3) - 538.226 * Math.pow((stFrequency / 60), 2) + 551.577 * (stFrequency / 60) - 187.057;
        } else {
            List<Number> pHumTestArr = new ArrayList<>();
            pHumTestArr.add(0);
            pHumTestArr.add(15);
            pHumTestArr.add(25);
            pHumTestArr.add(35);
            pHumTestArr.add(45);
            double pRelHumidityTestX1 = getIndex(pHumTestArr, getMatch(pRelHumidityTestX, pHumTestArr, 1));
            double pRelHumidityTestX2 = getIndex(pHumTestArr, getMatch(pRelHumidityTestX, pHumTestArr, 1) + 1);
            double pRelHumidityTest1 = -0.000000935858 * Math.pow((0.01 * ambientRH), 3) - 0.0000141332 * Math.pow((0.01 * ambientRH), 2) + 0.00381307 * (0.01 * ambientRH) + 0.997717;
            double pRelHumidityTest2 = -0.0000553283 * Math.pow((0.01 * ambientRH), 3) - 0.000688925 * Math.pow((0.01 * ambientRH), 2) + 0.00787826 * (0.01 * ambientRH) + 0.995533;
            double pRelHumidityTest3 = -0.0000548537 * Math.pow((0.01 * ambientRH), 3) - 0.000691077 * Math.pow((0.01 * ambientRH), 2) + 0.00786734 * (0.01 * ambientRH) + 0.99554;
            double pRelHumidityTest4 = 0.0000468319 * Math.pow((0.01 * ambientRH), 3) - 0.00547762 * Math.pow((0.01 * ambientRH), 2) + 0.00715796 * (0.01 * ambientRH) + 0.997667;
            double pRelHumidityTest5 = 0.0055358 * Math.pow((0.01 * ambientRH), 3) - 0.0286947 * Math.pow((0.01 * ambientRH), 2) - 0.00528963 * (0.01 * ambientRH) + 1.01231;
            List<Number> pHumArr = new ArrayList<>();
            pHumArr.add(pRelHumidityTest1);
            pHumArr.add(pRelHumidityTest2);
            pHumArr.add(pRelHumidityTest3);
            pHumArr.add(pRelHumidityTest4);
            pHumArr.add(pRelHumidityTest5);
            double pRelHumidityTestY1 = getIndex(pHumArr, getMatch(pRelHumidityTestX, pHumTestArr, 1));
            double pRelHumidityTestY2 = getIndex(pHumArr, getMatch(pRelHumidityTestX, pHumTestArr, 1) + 1);
            pRelHumidity = pRelHumidityTestY1 + (pRelHumidityTestX - pRelHumidityTestX1) * (pRelHumidityTestY2 - pRelHumidityTestY1) / (pRelHumidityTestX2 - pRelHumidityTestX1);
            List<Number> pSpdTestArr = new ArrayList<>();
            pSpdTestArr.add(0);
            pSpdTestArr.add(15);
            pSpdTestArr.add(25);
            pSpdTestArr.add(32);
            pSpdTestArr.add(46);
            double pRelEngineSpeedTestX1 = getIndex(pSpdTestArr, getMatch(pRelEngineSpeedTestX, pSpdTestArr, 1));
            double pRelEngineSpeedTestX2 = getIndex(pSpdTestArr, getMatch(pRelEngineSpeedTestX, pSpdTestArr, 1) + 1);
            double pRelEngineSpeedTest1 = 174.706 * Math.pow((stFrequency / 60), 3) - 538.226 * Math.pow((stFrequency / 60), 2) + 551.577 * (stFrequency / 60) - 187.057;
            double pRelEngineSpeedTest2 = -112.386 * Math.pow((stFrequency / 60), 3) + 301.717 * Math.pow((stFrequency / 60), 2) - 265.928 * (stFrequency / 60) + 77.597;
            double pRelEngineSpeedTest3 = 225.864 * Math.pow((stFrequency / 60), 3) - 710.323 * Math.pow((stFrequency / 60), 2) + 744.364 * (stFrequency / 60) - 258.905;
            double pRelEngineSpeedTest4 = -19.4615 * Math.pow((stFrequency / 60), 3) + 21.6669 * Math.pow((stFrequency / 60), 2) + 17.2299 * (stFrequency / 60) - 18.4353;
            double pRelEngineSpeedTest5 = -527.474 * Math.pow((stFrequency / 60), 3) + 1545.48 * Math.pow((stFrequency / 60), 2) - 1503.97 * (stFrequency / 60) + 486.964;
            List<Number> pSpdArr = new ArrayList<>();
            pSpdArr.add(pRelEngineSpeedTest1);
            pSpdArr.add(pRelEngineSpeedTest2);
            pSpdArr.add(pRelEngineSpeedTest3);
            pSpdArr.add(pRelEngineSpeedTest4);
            pSpdArr.add(pRelEngineSpeedTest5);
            double pRelEngineSpeedTestY1 = getIndex(pSpdArr, getMatch(pRelHumidityTestX, pSpdTestArr, 1));
            double pRelEngineSpeedTestY2 = getIndex(pSpdArr, getMatch(pRelHumidityTestX, pSpdTestArr, 1) + 1);
            pRelEngineSpeed = pRelEngineSpeedTestY1 + (pRelEngineSpeedTestX - pRelEngineSpeedTestX1) * (pRelEngineSpeedTestY2 - pRelEngineSpeedTestY1) / (pRelEngineSpeedTestX2 - pRelEngineSpeedTestX1);
        }
        double pFuelGasLHVTestX = chRatio(methane, ethane, propane, butane, isobutane, pentane, isopentane);
        List<Number> pGasTestArr = new ArrayList<>();
        pGasTestArr.add(2.979);
        pGasTestArr.add(3.155);
        pGasTestArr.add(3.3);
        pGasTestArr.add(3.45);
        double pFuelGasLHVTestX1 = getIndex(pGasTestArr, getMatch(pFuelGasLHVTestX, pGasTestArr, 1));
        double pFuelGasLHVTestX2 = getIndex(pGasTestArr, getMatch(pFuelGasLHVTestX, pGasTestArr, 1) + 1);
        double pFuelGasLHVTest1 = 0.0000311312 * Math.pow((lhv / 1000), 2) - 0.00391754 * (lhv / 1000) + 1.12045;
        double pFuelGasLHVTest2 = 0.0000309164 * Math.pow((lhv / 1000), 2) - 0.00389258 * (lhv / 1000) + 1.11677;
        double pFuelGasLHVTest3 = 0.0000314845 * Math.pow((lhv / 1000), 2) - 0.00393467 * (lhv / 1000) + 1.11524;
        double pFuelGasLHVTest4 = 0.0000318051 * Math.pow((lhv / 1000), 2) - 0.00395701 * (lhv / 1000) + 1.11333;
        List<Number> pGasArr = new ArrayList<>();
        pGasArr.add(pFuelGasLHVTest1);
        pGasArr.add(pFuelGasLHVTest2);
        pGasArr.add(pFuelGasLHVTest3);
        pGasArr.add(pFuelGasLHVTest4);
        double pFuelGasLHVTestY1 = getIndex(pGasArr, getMatch(pFuelGasLHVTestX, pGasTestArr, 1));
        double pFuelGasLHVTestY2 = getIndex(pGasArr, getMatch(pFuelGasLHVTestX, pGasTestArr, 1) + 1);
        double pFuelGasLHV = pFuelGasLHVTestY1 + (pFuelGasLHVTestX - pFuelGasLHVTestX1) * (pFuelGasLHVTestY2 - pFuelGasLHVTestY1) / (pFuelGasLHVTestX2 - pFuelGasLHVTestX1);
        double pOTCDeviation = -0.00000275451 * Math.pow(pOTCTestK(ambientT), 2) + 0.00196996 * pOTCTestK(ambientT) + 1;
        double pDiffusorExhaustPressureLoss = -0.000000706787 * Math.pow(gtExhaustPress, 2) - 0.000211037 * (gtExhaustPress) + 1.01134;
        List<Double> gtPowerCorrectionProductArr = new ArrayList<>();
        gtPowerCorrectionProductArr.add(ambP);
        gtPowerCorrectionProductArr.add(gtCompInletPLoss);
        gtPowerCorrectionProductArr.add(gtCompInletT);
        gtPowerCorrectionProductArr.add(pRelHumidity);
        gtPowerCorrectionProductArr.add(pRelEngineSpeed);
        gtPowerCorrectionProductArr.add(pFuelGasLHV);
        gtPowerCorrectionProductArr.add(pOTCDeviation);
        gtPowerCorrectionProductArr.add(pDiffusorExhaustPressureLoss);
        gtPowerCorrectionProductArr.add(pGTEquivalentBoxHours(gtEBH));
        double gtPowerCorrectionProduct = getProduct(gtPowerCorrectionProductArr) / 0.9972;
        double gtGrossPower = gtGrossPowerTag / gtPowerCorrectionProduct * pGTEquivalentBoxHours(gtEBH);
        return changeRound(gtGrossPower);
    };

    // 1CC 6번
    private static Function<List<Object>, Double> gt_designed_power = stack -> {
        Double gtEBH = (Double) popStack.apply(stack);
        double T192 = 292.012;
        double gtDesignedPower = T192 * pGTEquivalentBoxHours(gtEBH);
        return changeRound(gtDesignedPower);
    };

    // 1CC 7번
    private static Function<List<Object>, Double> gt_gross_efficiency = stack -> {
        // TODO 타엑셀
        Double gtFuelCp = (Double) popStack.apply(stack), gtDensity = (Double) popStack.apply(stack), reynoldsNumber = (Double) popStack.apply(stack), lhv = (Double) popStack.apply(stack), isopentane = (Double) popStack.apply(stack);
        Double pentane = (Double) popStack.apply(stack), isobutane = (Double) popStack.apply(stack), butane = (Double) popStack.apply(stack), propane = (Double) popStack.apply(stack), ethane = (Double) popStack.apply(stack);
        Double methane = (Double) popStack.apply(stack), stFrequency = (Double) popStack.apply(stack), gtGrossPowerTag = (Double) popStack.apply(stack), gasTAfterFPRH = (Double) popStack.apply(stack), gasFlowRate = (Double) popStack.apply(stack);
        Double gtEBH = (Double) popStack.apply(stack), compPin = (Double) popStack.apply(stack), compTin = (Double) popStack.apply(stack), ambientRH = (Double) popStack.apply(stack), ambientP = (Double) popStack.apply(stack);
        Double ambientT = (Double) popStack.apply(stack);
        double gtFuelEnthalpyAbove15C = gtFuelCp * (gasTAfterFPRH - 15);
        double gtFuelQinput = gtMassFlow(gasFlowRate, reynoldsNumber, gtDensity) * (lhv + gtFuelEnthalpyAbove15C) / 3600;
        double hrGtComprInletT;
        if (compTin < 15) {
            hrGtComprInletT = 0.00000998827 * Math.pow(compTin, 2) - 0.0000390012 * (compTin) + 0.998338;
        } else {
            hrGtComprInletT = 0.0000816215 * Math.pow(compTin, 2) - 0.00254304 * (compTin) + 1.01978;
        }
        double gtFilterDP = ambientP - compPin;
        double hrGtComprInletPLoss = 0.000303968 * gtFilterDP + 0.997568;
        double hrRelHumidity;
        double hrRelEngineSpeed;
        double hrRelHumidityTestX = ambientT;
        double hrRelEngineSpeedTestX =  ambientT;
        if(hrRelHumidityTestX < 0) {
            hrRelHumidity = 0.000012196 * Math.pow((0.01 * ambientRH), 2) + 0.000130036 * (0.01 * ambientRH) + 0.999918;
            hrRelEngineSpeed = 8.56974 * Math.pow((stFrequency / 60), 2) - 16.772 * (stFrequency / 60) + 9.20226;
        } else {
            List<Number> hrHumTestArr = new ArrayList<>();
            hrHumTestArr.add(0);
            hrHumTestArr.add(15);
            hrHumTestArr.add(25);
            hrHumTestArr.add(35);
            hrHumTestArr.add(45);
            double hrRelHumidityTestX1 = getIndex(hrHumTestArr, getMatch(hrRelHumidityTestX, hrHumTestArr, 1));
            double hrRelHumidityTestX2 = getIndex(hrHumTestArr, getMatch(hrRelHumidityTestX, hrHumTestArr, 1) + 1);
            double hrRelHumidityTest1 = 0.000012196 * Math.pow((0.01 * ambientRH), 2) + 0.000130036 * (0.01 * ambientRH) + 0.999918;
            double hrRelHumidityTest2 = 0.000270936 * Math.pow((0.01 * ambientRH), 2) + 0.0012887 * (0.01 * ambientRH) + 0.999129;
            double hrRelHumidityTest3 = 0.000631947 * Math.pow((0.01 * ambientRH), 2) + 0.00344285 * (0.01 * ambientRH) + 0.997707;
            double hrRelHumidityTest4 = 0.00228459 * Math.pow((0.01 * ambientRH), 2) + 0.0076479 * (0.01 * ambientRH) + 0.994589;
            double hrRelHumidityTest5 = 0.00615837 * Math.pow((0.01 * ambientRH), 2) + 0.0266238 * (0.01 * ambientRH) + 0.981809;
            List<Number> hrHumArr = new ArrayList<>();
            hrHumArr.add(hrRelHumidityTest1);
            hrHumArr.add(hrRelHumidityTest2);
            hrHumArr.add(hrRelHumidityTest3);
            hrHumArr.add(hrRelHumidityTest4);
            hrHumArr.add(hrRelHumidityTest5);
            double hrRelHumidityTestY1 = getIndex(hrHumArr, getMatch(hrRelHumidityTestX, hrHumTestArr, 1));
            double hrRelHumidityTestY2 = getIndex(hrHumArr, getMatch(hrRelHumidityTestX, hrHumTestArr, 1) + 1);
            hrRelHumidity = hrRelHumidityTestY1 + (hrRelHumidityTestX - hrRelHumidityTestX1) * (hrRelHumidityTestY2 - hrRelHumidityTestY1) / (hrRelHumidityTestX2 - hrRelHumidityTestX1);
            List<Number> hrSpdTestArr = new ArrayList<>();
            hrSpdTestArr.add(0);
            hrSpdTestArr.add(15);
            hrSpdTestArr.add(25);
            hrSpdTestArr.add(32);
            hrSpdTestArr.add(46);
            double hrRelEngineSpeedTestX1 = getIndex(hrSpdTestArr, getMatch(hrRelEngineSpeedTestX, hrSpdTestArr, 1));
            double hrRelEngineSpeedTestX2 = getIndex(hrSpdTestArr, getMatch(hrRelEngineSpeedTestX, hrSpdTestArr, 1) + 1);
            double hrRelEngineSpeedTest1 = 8.56974 * Math.pow((stFrequency / 60), 2) - 16.772 * (stFrequency / 60) + 9.20226;
            double hrRelEngineSpeedTest2 = 14.2284 * Math.pow((stFrequency / 60), 2) - 28.4244 * (stFrequency / 60) + 15.196;
            double hrRelEngineSpeedTest3 = 13.0933 * Math.pow((stFrequency / 60), 2) - 26.4545 * (stFrequency / 60) + 14.3612;
            double hrRelEngineSpeedTest4 = 15.4076 * Math.pow((stFrequency / 60), 2) - 31.3277 * (stFrequency / 60) + 16.9201;
            double hrRelEngineSpeedTest5 = 24.1123 * Math.pow((stFrequency / 60), 2) - 49.827 * (stFrequency / 60) + 26.7147;
            List<Number> hrSpdArr = new ArrayList<>();
            hrSpdArr.add(hrRelEngineSpeedTest1);
            hrSpdArr.add(hrRelEngineSpeedTest2);
            hrSpdArr.add(hrRelEngineSpeedTest3);
            hrSpdArr.add(hrRelEngineSpeedTest4);
            hrSpdArr.add(hrRelEngineSpeedTest5);
            double hrRelEngineSpeedTestY1 = getIndex(hrSpdArr, getMatch(hrRelEngineSpeedTestX, hrSpdTestArr, 1));
            double hrRelEngineSpeedTestY2 = getIndex(hrSpdArr, getMatch(hrRelEngineSpeedTestX, hrSpdTestArr, 1) + 1);
            hrRelEngineSpeed = hrRelEngineSpeedTestY1 + (hrRelEngineSpeedTestX - hrRelEngineSpeedTestX1) * (hrRelEngineSpeedTestY2 - hrRelEngineSpeedTestY1) / (hrRelEngineSpeedTestX2 - hrRelEngineSpeedTestX1);
        }
        double hrFuelGasLHVTestX = chRatio(methane, ethane, propane, butane, isobutane, pentane, isopentane);
        List<Number> hrGasTestArr = new ArrayList<>();
        hrGasTestArr.add(2.979);
        hrGasTestArr.add(3.155);
        hrGasTestArr.add(3.3);
        hrGasTestArr.add(3.45);
        double hrFuelGasLHVTestX1 = getIndex(hrGasTestArr, getMatch(hrFuelGasLHVTestX, hrGasTestArr, 1));
        double hrFuelGasLHVTestX2 = getIndex(hrGasTestArr, getMatch(hrFuelGasLHVTestX, hrGasTestArr, 1) + 1);
        double hrFuelGasLHVTest1 = -0.00000921516 * Math.pow((0.001 * lhv), 2) + 0.00119282 * (0.001 * lhv) + 0.962838;
        double hrFuelGasLHVTest2 = -0.00000923981 * Math.pow((0.001 * lhv), 2) + 0.00119605 * (0.001 * lhv) + 0.96349;
        double hrFuelGasLHVTest3 = -0.00000945902 * Math.pow((0.001 * lhv), 2) + 0.00121527 * (0.001 * lhv) + 0.963644;
        double hrFuelGasLHVTest4 = -0.00000961569 * Math.pow((0.001 * lhv), 2) + 0.00122947 * (0.001 * lhv) + 0.963899;
        List<Number> hrGasArr = new ArrayList<>();
        hrGasArr.add(hrFuelGasLHVTest1);
        hrGasArr.add(hrFuelGasLHVTest2);
        hrGasArr.add(hrFuelGasLHVTest3);
        hrGasArr.add(hrFuelGasLHVTest4);
        double hrFuelGasLHVTestY1 = getIndex(hrGasArr, getMatch(hrFuelGasLHVTestX, hrGasTestArr, 1));
        double hrFuelGasLHVTestY2 = getIndex(hrGasArr, getMatch(hrFuelGasLHVTestX, hrGasTestArr, 1) + 1);
        double hrFuelGasLHV = hrFuelGasLHVTestY1 + (hrFuelGasLHVTestX - hrFuelGasLHVTestX1) * (hrFuelGasLHVTestY2 - hrFuelGasLHVTestY1) / (hrFuelGasLHVTestX2 - hrFuelGasLHVTestX1);
        double hrOTCDeviation = 0.00000203144 * Math.pow(pOTCTestK(ambientT), 2) - 0.0000754444 * pOTCTestK(ambientT) + 1;
        List<Double> hrGtHrCorrectionProductArr = new ArrayList<>();
        hrGtHrCorrectionProductArr.add(hrGtComprInletT);
        hrGtHrCorrectionProductArr.add(hrGtComprInletPLoss);
        hrGtHrCorrectionProductArr.add(hrRelHumidity);
        hrGtHrCorrectionProductArr.add(hrRelEngineSpeed);
        hrGtHrCorrectionProductArr.add(hrFuelGasLHV);
        hrGtHrCorrectionProductArr.add(hrOTCDeviation);
        hrGtHrCorrectionProductArr.add(hrGTEquivalentBoxHours(gtEBH));
        double hrGtHrCorrectionProduct = getProduct(hrGtHrCorrectionProductArr) / 1.0007;
        double gtGrossEfficiency = (gtGrossPowerTag * 1000) / gtFuelQinput * (hrGtHrCorrectionProduct / hrGTEquivalentBoxHours(gtEBH));
        return changeRound(gtGrossEfficiency * 100);
    };

    // 1CC 8번
    private static Function<List<Object>, Double> gt_designed_efficiency = stack -> {
        Double gtEBH = (Double) popStack.apply(stack);
        double T194 = 0.3957;
        double gtDesignedEfficiency = T194 / hrGTEquivalentBoxHours(gtEBH);
        return changeRound(gtDesignedEfficiency * 100);
    };

    // 1CC 9번
    private static Function<List<Object>, Double> gt_compr_efficiency_polytropic = stack -> {
        Double compPout = (Double) popStack.apply(stack), compTout = (Double) popStack.apply(stack), compPin = (Double) popStack.apply(stack), compTin = (Double) popStack.apply(stack);
        double gtComprEfficiencyPolytropic = (0.4 / 1.4) * Math.log(compPout / (compPin / 1000)) / Math.log((compTout + 273.15) / (compTin + 273.15));
        return changeRound(gtComprEfficiencyPolytropic * 100);
    };

    // 1CC 10번
    private static Function<List<Object>, Double> gt_pressrure_ratio = stack -> {
        Double compPout = (Double) popStack.apply(stack), compPin = (Double) popStack.apply(stack);
        double gtPressrurueRatio = compPout * 1000 / compPin;
        return changeRound(gtPressrurueRatio);
    };

    // 10ST 1번
    private static Function<List<Object>, Double> st_power_output = stack -> {
        Double stGrossPower = (Double) popStack.apply(stack);
        double stPowerOutput = stGrossPower;
        return changeRound(stPowerOutput);
    };

    // 10ST 2번
    private static Function<List<Object>, Double> st_energy_in = stack -> {
    	Double condensateWaterF = (Double) popStack.apply(stack), steamFromLPBoiler1F = (Double) popStack.apply(stack), steamFromLPBoilerT = (Double) popStack.apply(stack);
        Double steamFromLPBoilerP = (Double) popStack.apply(stack), steamFromHRHBoiler1F = (Double) popStack.apply(stack), steamFromHRHBoiler1T = (Double) popStack.apply(stack); 
		Double steamFromHRHBoiler1P = (Double) popStack.apply(stack), steamToCRHBoilerT = (Double) popStack.apply(stack), steamToCRHBoilerP = (Double) popStack.apply(stack); 
		Double steamFromHPBoiler1F = (Double) popStack.apply(stack), steamFromHPBoiler1T = (Double) popStack.apply(stack), steamFromHPBoiler1P = (Double) popStack.apply(stack); 
        Double stCondenserP = (Double) popStack.apply(stack); 
        double cSteamFromHPBoiler1F = steamFromHPBoiler1F;
        double cSteamToCRHBoiler1F = steamFromHPBoiler1F;
        double cSteamFromHRHBoiler1F = steamFromHRHBoiler1F;
        double cSteaFromLPBoiler1F = steamFromLPBoiler1F;
        double steamFromHPBoiler1H = UniSteamCal.INSTANCE.STEAMPTH(steamFromHPBoiler1P, steamFromHPBoiler1T, 0);
        double steamToCRHBoiler1H = UniSteamCal.INSTANCE.STEAMPTH(steamToCRHBoilerP, steamToCRHBoilerT, 0);
        double steamFromHRHBoiler1H = UniSteamCal.INSTANCE.STEAMPTH(steamFromHRHBoiler1P, steamFromHRHBoiler1T, 0);
        double steamFromLPBoiler1H = UniSteamCal.INSTANCE.STEAMPTH(steamFromLPBoilerP, steamFromLPBoilerT, 0);
        double condensateTemp = UniSteamCal.INSTANCE.STEAMPT(stCondenserP, 0);
        double condensateWaterToCondensorH = UniSteamCal.INSTANCE.STEAMPTH(stCondenserP, condensateTemp, 0);
        double energyInFromHPBoiler = (steamFromHPBoiler1H * cSteamFromHPBoiler1F) / 1000;
        double energyOutToCRHBoiler = -steamToCRHBoiler1H / 1000 * cSteamToCRHBoiler1F;
        double energyInFromHRHBoiler = (steamFromHRHBoiler1H * cSteamFromHRHBoiler1F) / 1000;
        double energyInFromLPBoiler = steamFromLPBoiler1H / 1000 * cSteaFromLPBoiler1F;
        double cCondensateWaterF = condensateWaterF / 3.6;
        double energyOutToCondensorPreHeater = -condensateWaterToCondensorH * cCondensateWaterF / 1000;
        double stEnergyIn = (energyInFromHPBoiler + energyInFromHRHBoiler + energyInFromLPBoiler) + (energyOutToCRHBoiler + energyOutToCondensorPreHeater);
        return changeRound(stEnergyIn);
    };

    // 10ST 3번
    private static Function<List<Object>, Double> st_efficiency = stack -> {
    	Double stGrossPower = (Double) popStack.apply(stack), condensateWaterF = (Double) popStack.apply(stack), steamFromLPBoiler1F = (Double) popStack.apply(stack), steamFromLPBoilerT = (Double) popStack.apply(stack);
        Double steamFromLPBoilerP = (Double) popStack.apply(stack), steamFromHRHBoiler1F = (Double) popStack.apply(stack), steamFromHRHBoiler1T = (Double) popStack.apply(stack); 
		Double steamFromHRHBoiler1P = (Double) popStack.apply(stack), steamToCRHBoilerT = (Double) popStack.apply(stack), steamToCRHBoilerP = (Double) popStack.apply(stack); 
		Double steamFromHPBoiler1F = (Double) popStack.apply(stack), steamFromHPBoiler1T = (Double) popStack.apply(stack), steamFromHPBoiler1P = (Double) popStack.apply(stack); 
        Double stCondenserP = (Double) popStack.apply(stack); 
        List<Object> outPutArr = new ArrayList();
        outPutArr.add(stGrossPower);
        List<Object> inArr = new ArrayList();
        inArr.add(stCondenserP);
        inArr.add(steamFromHPBoiler1P);
        inArr.add(steamFromHPBoiler1T);
        inArr.add(steamFromHPBoiler1F);
        inArr.add(steamToCRHBoilerP);
        inArr.add(steamToCRHBoilerT);
        inArr.add(steamFromHRHBoiler1P);
        inArr.add(steamFromHRHBoiler1T);
        inArr.add(steamFromHRHBoiler1F);
        inArr.add(steamFromLPBoilerP);
        inArr.add(steamFromLPBoilerT);
        inArr.add(steamFromLPBoiler1F);
        inArr.add(condensateWaterF);
        double stPowerOutput = st_power_output.apply(outPutArr);
        double stEnergyIn = st_energy_in.apply(inArr);

		System.out.println("stPowerOutput : " + stPowerOutput);
		System.out.println("stEnergyIn : " + stEnergyIn);
        double st10Efficiency = stPowerOutput / stEnergyIn;
        return changeRound(st10Efficiency * 100);
    };

    // 10Cond 1번
    private static Function<List<Object>, Double> cond_p = stack -> {
        Double stCondenserP = (Double) popStack.apply(stack);
        double cond10P = stCondenserP;
        return changeRound(cond10P);
    };

    // 10Cond 2번
    private static Function <List<Object>, Double> cond_sat_t = stack -> {
        Double stCondenserP = (Double) popStack.apply(stack);
        double cond10SatT = UniSteamCal.INSTANCE.STEAMPT(stCondenserP, 0);
        return changeRound(cond10SatT);
    };

    // 10Cond 3번
    private static Function<List<Object>, Double> ttd = stack -> {
        Double stCondenserP = (Double) popStack.apply(stack), condOutCWT = (Double) popStack.apply(stack);
        double condenserHotwellT = UniSteamCal.INSTANCE.STEAMPT(stCondenserP, 0);
        double terminalTempDifference = condenserHotwellT - condOutCWT;
        double tTD = terminalTempDifference;
        return changeRound(tTD);
    };

    // 10Cond 4번
    private static Function<List<Object>, Double> itd = stack -> {
        Double stCondenserP = (Double) popStack.apply(stack), ambientRH = (Double) popStack.apply(stack), ambientT = (Double) popStack.apply(stack);
        double ambientWetT = ambientT * Math.atan(0.151977 * Math.pow((ambientRH + 8.313659), 0.5))+ Math.atan(ambientT + ambientRH) - Math.atan(ambientRH - 1.676331) + 0.00391838 * Math.pow(ambientRH, 1.5) * Math.atan(0.023101 * ambientRH) - 4.686035;
        double condenserHotwellT = UniSteamCal.INSTANCE.STEAMPT(stCondenserP, 0);
        double initialTempDifference = condenserHotwellT - ambientWetT;
        double iTD =  initialTempDifference;
        return changeRound(iTD);
    };

    // 10Cond 5번
    private static Function<List<Object>, Double> cw_t_rise = stack -> {
        Double condOutCWT = (Double) popStack.apply(stack), condInCWT = (Double) popStack.apply(stack);
        double cwTRise = condOutCWT - condInCWT;
        return changeRound(cwTRise);
    };

    // 10Cond 6번
    private static Function<List<Object>, Double> st_ueep = stack -> {
        Double stGrossPower = (Double) popStack.apply(stack), condenserMakeUpWaterF = (Double) popStack.apply(stack), afterCEPWaterF = (Double) popStack.apply(stack);   
        Double steamFromLPBoiler1F = (Double) popStack.apply(stack), steamFromLPBoilerT = (Double) popStack.apply(stack), steamFromLPBoilerP = (Double) popStack.apply(stack);
        Double steamFromHRHBoiler1F = (Double) popStack.apply(stack), steamFromHRHBoiler1T = (Double) popStack.apply(stack), steamFromHRHBoiler1P = (Double) popStack.apply(stack); 
        Double steamToCRHBoilerT = (Double) popStack.apply(stack), steamToCRHBoilerP = (Double) popStack.apply(stack), steamFromHPBoiler1F = (Double) popStack.apply(stack);
        Double steamFromHPBoiler1T = (Double) popStack.apply(stack), steamFromHPBoiler1P = (Double) popStack.apply(stack), stCondenserP = (Double) popStack.apply(stack); 
        double steamFromHPBoiler1H = UniSteamCal.INSTANCE.STEAMPTH(steamFromHPBoiler1P, steamFromHPBoiler1T, 0);
        double steamToCRHBoiler1H = UniSteamCal.INSTANCE.STEAMPTH(steamToCRHBoilerP, steamToCRHBoilerT, 0);
        double steamFromHRHBoiler1H = UniSteamCal.INSTANCE.STEAMPTH(steamFromHRHBoiler1P, steamFromHRHBoiler1T, 0);
        double steamFromLPBoiler1H = UniSteamCal.INSTANCE.STEAMPTH(steamFromLPBoilerP, steamFromLPBoilerT, 0);
        double condensateTemp = UniSteamCal.INSTANCE.STEAMPT(stCondenserP, 0);
        double condensateWaterToCondensorH = UniSteamCal.INSTANCE.STEAMPTH(stCondenserP, condensateTemp, 0);
        System.out.println("steamFromHPBoiler1H : " + steamFromHPBoiler1H);
        System.out.println("steamToCRHBoiler1H : " + steamToCRHBoiler1H);
        System.out.println("steamFromHRHBoiler1H : " + steamFromHRHBoiler1H);
        System.out.println("steamFromLPBoiler1H : " + steamFromLPBoiler1H);
        System.out.println("condensateTemp : " + condensateTemp);
        System.out.println("condensateWaterToCondensorH : " + condensateWaterToCondensorH);
        double condensateWaterF = afterCEPWaterF - condenserMakeUpWaterF;
        double stUEEP = stEnergyInSTEnergyOut(steamFromHPBoiler1F, steamFromHRHBoiler1F, steamFromLPBoiler1F, stGrossPower, steamFromHPBoiler1H, steamToCRHBoiler1H, steamFromHRHBoiler1H, steamFromLPBoiler1H, condensateWaterToCondensorH, condensateWaterF)
                / afterCEPWaterF * 1000; // 6번
        return changeRound(stUEEP);
    };

    // 10Cond 7번
    private static Function<List<Object>, Double> condensate_water_h = stack -> {
        Double stCondenserP = (Double) popStack.apply(stack);
        double condenserHotwellT = UniSteamCal.INSTANCE.STEAMPT(stCondenserP, 0);
        double condensateWaterHTag = UniSteamCal.INSTANCE.STEAMPTH(stCondenserP, condenserHotwellT, 0);
        double condensateWaterH = condensateWaterHTag;
        return changeRound(condensateWaterH);
    };

    // 10Cond 8번
    private static Function<List<Object>, Double> condensate_water_f = stack -> {
        Double afterCEPWaterF = (Double) popStack.apply(stack);
        double condensateWaterF = afterCEPWaterF / 3.6;
        return changeRound(condensateWaterF);
    };

    // 10Cond 9번
    private static Function<List<Object>, Double> condenser_heat_load = stack -> {
    	Double stGrossPower = (Double) popStack.apply(stack), condenserMakeUpWaterF = (Double) popStack.apply(stack), afterCEPWaterF = (Double) popStack.apply(stack);   
        Double steamFromLPBoiler1F = (Double) popStack.apply(stack), steamFromLPBoilerT = (Double) popStack.apply(stack), steamFromLPBoilerP = (Double) popStack.apply(stack);
        Double steamFromHRHBoiler1F = (Double) popStack.apply(stack), steamFromHRHBoiler1T = (Double) popStack.apply(stack), steamFromHRHBoiler1P = (Double) popStack.apply(stack); 
        Double steamToCRHBoilerT = (Double) popStack.apply(stack), steamToCRHBoilerP = (Double) popStack.apply(stack), steamFromHPBoiler1F = (Double) popStack.apply(stack);
        Double steamFromHPBoiler1T = (Double) popStack.apply(stack), steamFromHPBoiler1P = (Double) popStack.apply(stack), stCondenserP = (Double) popStack.apply(stack); 
        List<Object> ueepArr = new ArrayList();
        ueepArr.add(stCondenserP);
        ueepArr.add(steamFromHPBoiler1P);
        ueepArr.add(steamFromHPBoiler1T);
        ueepArr.add(steamFromHPBoiler1F);
        ueepArr.add(steamToCRHBoilerP);
        ueepArr.add(steamToCRHBoilerT);
        ueepArr.add(steamFromHRHBoiler1P);
        ueepArr.add(steamFromHRHBoiler1T);
        ueepArr.add(steamFromHRHBoiler1F);
        ueepArr.add(steamFromLPBoilerP);
        ueepArr.add(steamFromLPBoilerT);
        ueepArr.add(steamFromLPBoiler1F);
        ueepArr.add(afterCEPWaterF);
        ueepArr.add(condenserMakeUpWaterF);
        ueepArr.add(stGrossPower);
        List<Object> waterArr = new ArrayList();
        waterArr.add(stCondenserP);
        double condenserHeatLoad = (st_ueep.apply(ueepArr) - condensate_water_h.apply(waterArr))
                * (afterCEPWaterF - condenserMakeUpWaterF) / 1000;
        return changeRound(condenserHeatLoad);
    };

    // 10Cond 10번
    private static Function<List<Object>, Double> cond_cleanliness = stack -> {
    	Double stGrossPower = (Double) popStack.apply(stack), condenserMakeUpWaterF = (Double) popStack.apply(stack), afterCEPWaterF = (Double) popStack.apply(stack);   
        Double steamFromLPBoiler1F = (Double) popStack.apply(stack), steamFromLPBoilerT = (Double) popStack.apply(stack), steamFromLPBoilerP = (Double) popStack.apply(stack);
        Double steamFromHRHBoiler1F = (Double) popStack.apply(stack), steamFromHRHBoiler1T = (Double) popStack.apply(stack), steamFromHRHBoiler1P = (Double) popStack.apply(stack); 
        Double steamToCRHBoilerT = (Double) popStack.apply(stack), steamToCRHBoilerP = (Double) popStack.apply(stack), steamFromHPBoiler1F = (Double) popStack.apply(stack);
        Double steamFromHPBoiler1T = (Double) popStack.apply(stack), steamFromHPBoiler1P = (Double) popStack.apply(stack), stCondenserP = (Double) popStack.apply(stack); 
        Double condOutCWT = (Double) popStack.apply(stack), condInCWT = (Double) popStack.apply(stack), ambientRH = (Double) popStack.apply(stack), ambientT = (Double) popStack.apply(stack);
        List<Object> ueepArr = new ArrayList();
        ueepArr.add(stCondenserP);
        ueepArr.add(steamFromHPBoiler1P);
        ueepArr.add(steamFromHPBoiler1T);
        ueepArr.add(steamFromHPBoiler1F);
        ueepArr.add(steamToCRHBoilerP);
        ueepArr.add(steamToCRHBoilerT);
        ueepArr.add(steamFromHRHBoiler1P);
        ueepArr.add(steamFromHRHBoiler1T);
        ueepArr.add(steamFromHRHBoiler1F);
        ueepArr.add(steamFromLPBoilerP);
        ueepArr.add(steamFromLPBoilerT);
        ueepArr.add(steamFromLPBoiler1F);
        ueepArr.add(afterCEPWaterF);
        ueepArr.add(condenserMakeUpWaterF);
        ueepArr.add(stGrossPower);
        double condenserHotwellT = UniSteamCal.INSTANCE.STEAMPT(stCondenserP, 0);
        double condensateWaterHTag = UniSteamCal.INSTANCE.STEAMPTH(stCondenserP, condenserHotwellT, 0);
        double heatLoadOnCondenser = (st_ueep.apply(ueepArr) - condensateWaterHTag) * (afterCEPWaterF - condenserMakeUpWaterF) / 1000;
        double ambientWetT = ambientT * Math.atan(0.151977 * Math.pow((ambientRH + 8.313659), 0.5)) + Math.atan(ambientT + ambientRH) - Math.atan(ambientRH - 1.676331) + 0.00391838*Math.pow(ambientRH, 1.5) * Math.atan(0.023101 * ambientRH) - 4.686035;
        double initialTempDifference = condenserHotwellT - ambientWetT;
        double terminalTempDifference = condenserHotwellT - condOutCWT; // 현재 condenserHotwellT가 고정값이라 terminalTempDifference 값이 음수가 나올경우 에러 발생
        double G52 = condInCWT * 9 / 5 + 32;
        List<Number> unitArr = new ArrayList<>();
        unitArr.add(35);
        unitArr.add(40);
        unitArr.add(45);
        unitArr.add(50);
        unitArr.add(55);
        unitArr.add(60);
        unitArr.add(70);
        unitArr.add(80);
        unitArr.add(90);
        unitArr.add(100);
        List<Number> tagArr = new ArrayList<>();
        tagArr.add(0.57);
        tagArr.add(0.64);
        tagArr.add(0.72);
        tagArr.add(0.79);
        tagArr.add(0.86);
        tagArr.add(0.92);
        tagArr.add(1);
        tagArr.add(1.04);
        tagArr.add(1.08);
        tagArr.add(1.1);
        double fromThermoflexTestX1 = getIndex(unitArr, getMatch(G52, unitArr, 1));
        double fromThermoflexTestX2 = getIndex(unitArr, getMatch(G52, unitArr, 1) + 1);
        double fromThermoflexTestY1 = getIndex(tagArr, getMatch(G52, unitArr, 1));
        double fromThermoflexTestY2 = getIndex(tagArr, getMatch(G52, unitArr, 1) + 1);
        double cwInletTFactor = fromThermoflexTestY1 + (G52 - fromThermoflexTestX1) * (fromThermoflexTestY2 - fromThermoflexTestY1) / (fromThermoflexTestX2 - fromThermoflexTestX1);
        double logarithmicMeanTemp = (initialTempDifference - terminalTempDifference) / Math.log(initialTempDifference / terminalTempDifference);
        double totalOutsideTubeSurfaceAreaTag = 14050;
        double tubeODFactorTag = 2582;
        double tubeMaterialAndGaugeFactorTag = 0.89;
        double cwVelocityTag = 1.97;
        double cond10Cleanliness = 1000000 * heatLoadOnCondenser / (tubeODFactorTag * cwInletTFactor * tubeMaterialAndGaugeFactorTag * Math.sqrt(cwVelocityTag) * totalOutsideTubeSurfaceAreaTag * logarithmicMeanTemp); // 10번
        return changeRound(cond10Cleanliness * 100);
    };

    // 11HRSG 1번
    private static Function<List<Object>, Double> hrsg_energy_in = stack -> {
        // TODO 타엑셀
        Double specificEnthalpyOfFuel77degF = (Double) popStack.apply(stack), specificEnthalpyOfFuelProcessTemperature = (Double) popStack.apply(stack), gtHVnet59degF = (Double) popStack.apply(stack);
        Double gtFuelNitrogenMolarFlow = (Double) popStack.apply(stack), gtDensity = (Double) popStack.apply(stack), reynoldsNumber = (Double) popStack.apply(stack), isopentane = (Double) popStack.apply(stack);
        Double pentane = (Double) popStack.apply(stack), isobutane = (Double) popStack.apply(stack), butane = (Double) popStack.apply(stack), propane = (Double) popStack.apply(stack), ethane = (Double) popStack.apply(stack);
        Double methane = (Double) popStack.apply(stack), nitrogen = (Double) popStack.apply(stack), gtGrossPowerTag = (Double) popStack.apply(stack), gasFlowRate = (Double) popStack.apply(stack);
        Double gtExhaustTemp = (Double) popStack.apply(stack), compTin = (Double) popStack.apply(stack), ambientRH = (Double) popStack.apply(stack), ambientP = (Double) popStack.apply(stack), ambientT = (Double) popStack.apply(stack);
        double hrsgGTExhaustEnergy = hrsgMassFlowOfBalanceOfAir(ambientT, ambientP, ambientRH, compTin, gtExhaustTemp, gasFlowRate,
                gtGrossPowerTag, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane,
                reynoldsNumber, gtDensity, gtFuelNitrogenMolarFlow, gtHVnet59degF, specificEnthalpyOfFuelProcessTemperature, specificEnthalpyOfFuel77degF)
                * gtHaOut(ambientT, ambientP, ambientRH, gtExhaustTemp)
                + gtMcombprod(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane,
                isobutane, pentane, isopentane, reynoldsNumber, gtDensity)
                * gtHgOut(ambientT, ambientP, ambientRH, gtExhaustTemp, gasFlowRate, nitrogen, methane, ethane, propane,
                butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity,
                gtFuelNitrogenMolarFlow);
        double energyIn = hrsgGTExhaustEnergy * 1.0548 / 1000 / 3600;
        return changeRound(energyIn);
    };

    // 11HRSG 2번
    private static Function<List<Object>, Double> hrsg_energy_out = stack -> {
        // TODO 타엑셀
        Double specificEnthalpyOfFuel77degF = (Double) popStack.apply(stack), specificEnthalpyOfFuelProcessTemperature = (Double) popStack.apply(stack), gtHVnet59degF = (Double) popStack.apply(stack);
        Double gtFuelNitrogenMolarFlow = (Double) popStack.apply(stack), gtDensity = (Double) popStack.apply(stack), reynoldsNumber = (Double) popStack.apply(stack), isopentane = (Double) popStack.apply(stack);
        Double pentane = (Double) popStack.apply(stack), isobutane = (Double) popStack.apply(stack), butane = (Double) popStack.apply(stack), propane = (Double) popStack.apply(stack), ethane = (Double) popStack.apply(stack);
        Double methane = (Double) popStack.apply(stack), nitrogen = (Double) popStack.apply(stack), gtGrossPowerTag = (Double) popStack.apply(stack), gasFlowRate = (Double) popStack.apply(stack);
        Double gtExhaustTemp = (Double) popStack.apply(stack), compTin = (Double) popStack.apply(stack), ambientRH = (Double) popStack.apply(stack), ambientP = (Double) popStack.apply(stack), ambientT = (Double) popStack.apply(stack);
        List<Double> gt11GasArr = new ArrayList<>();
        gt11GasArr.add(gtNitrogen(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane,
                butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity, gtFuelNitrogenMolarFlow));
        gt11GasArr.add(gtOxygen(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane,
                isobutane, pentane, isopentane, reynoldsNumber, gtDensity));
        gt11GasArr.add(gtCarbonDioxide(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane,
                butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity));
        gt11GasArr.add(gtArgon(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane,
                isobutane, pentane, isopentane, reynoldsNumber, gtDensity));
        gt11GasArr.add(gtWater(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane,
                isobutane, pentane, isopentane, reynoldsNumber, gtDensity));
        List<Number> airArr = new ArrayList<>();
        airArr.add(26.9927);
        airArr.add(23.965);
        airArr.add(22.6741);
        airArr.add(13.4997);
        airArr.add(48.6042);
        double hrsgStackEnthalpyCombProduct = getSumArr(gt11GasArr, airArr);
        List<Double> massAirArr = new ArrayList<>();
        massAirArr.add(mFN2(ambientT, ambientP, ambientRH));
        massAirArr.add(mFO2(ambientT, ambientP, ambientRH));
        massAirArr.add(mFCo2(ambientT, ambientP, ambientRH));
        massAirArr.add(mFAr2(ambientT, ambientP, ambientRH));
        massAirArr.add(mFH2O(ambientT, ambientP, ambientRH));
        List<Number> balanceAirArr = new ArrayList<>();
        balanceAirArr.add(26.9927);
        balanceAirArr.add(23.965);
        balanceAirArr.add(22.6741);
        balanceAirArr.add(13.4997);
        balanceAirArr.add(48.6042);
        double hrsgStackEnthalpyBalanceOfAir = getSumArr(massAirArr, balanceAirArr);
        double hrsgStackEnergy = gtMcombprod(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane,
                propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity)
                * hrsgStackEnthalpyCombProduct
                + hrsgMassFlowOfBalanceOfAir(ambientT, ambientP, ambientRH, compTin, gtExhaustTemp, gasFlowRate, gtGrossPowerTag, nitrogen,
                methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity,
                gtFuelNitrogenMolarFlow, gtHVnet59degF, specificEnthalpyOfFuelProcessTemperature, specificEnthalpyOfFuel77degF)
                * hrsgStackEnthalpyBalanceOfAir;
        double energyOut = hrsgStackEnergy * 1054.8 / 1000000 / 3600;
        return changeRound(energyOut);
    };

    // 11HRSG 3번
    private static Function<List<Object>, Double> hrsg_working_fluid_energy_gain = stack -> {
        // TODO 타엑셀
        Double hrsgLPSteamMassflow = (Double) popStack.apply(stack), hrsgLPSteamEnthalpy = (Double) popStack.apply(stack), hrsgHRHSteamMassflow = (Double) popStack.apply(stack), hrsgHRHSteamEnthalpy = (Double) popStack.apply(stack);
        Double hrsgHPSteamMassflow = (Double) popStack.apply(stack), hrsgHPSteameEthalpy = (Double) popStack.apply(stack), ipSystemToColdReheatMassflow = (Double) popStack.apply(stack), ipSystemToColdReheatEnthalpy = (Double) popStack.apply(stack);
        Double stColdReheatMassflowTo11HRSG = (Double) popStack.apply(stack), stColdReheatEnthalpy = (Double) popStack.apply(stack), fgHTREnthalpy = (Double) popStack.apply(stack), fgHTRMassflow = (Double) popStack.apply(stack);
        Double fwEnthalpy = (Double) popStack.apply(stack), fwMassflow = (Double) popStack.apply(stack), hrsgCondensateEnthalpy = (Double) popStack.apply(stack), hrsgCondensateMassflow = (Double) popStack.apply(stack);
        double hrsgCondenserProheaterEnergyIn = (hrsgCondensateEnthalpy * hrsgCondensateMassflow + fwMassflow * fwEnthalpy + fgHTRMassflow * fgHTREnthalpy) / 1000;
        double hrsgColdReheatEnergyIn = (stColdReheatEnthalpy * stColdReheatMassflowTo11HRSG + ipSystemToColdReheatEnthalpy * ipSystemToColdReheatMassflow) / 1000;
        double hrsgHPSteamEnergyOut = hrsgHPSteameEthalpy * hrsgHPSteamMassflow / 1000;
        double hrsgHRHSteamEnergyOut = hrsgHRHSteamEnthalpy * hrsgHRHSteamMassflow / 1000;
        double hrsgLPSteamEnergyOut = hrsgLPSteamEnthalpy * hrsgLPSteamMassflow / 1000;
        double energyGain = hrsgHPSteamEnergyOut + hrsgHRHSteamEnergyOut + hrsgLPSteamEnergyOut - (hrsgCondenserProheaterEnergyIn + hrsgColdReheatEnergyIn);
        return changeRound(energyGain);
    };

    // 11HRSG 4번
    private static Function<List<Object>, Double> hrsg_efficiency = stack -> {
        // TODO 타엑셀
        Double hrsgLPSteamMassflow = (Double) popStack.apply(stack), hrsgLPSteamEnthalpy = (Double) popStack.apply(stack), hrsgHRHSteamMassflow = (Double) popStack.apply(stack), hrsgHRHSteamEnthalpy = (Double) popStack.apply(stack);
        Double hrsgHPSteamMassflow = (Double) popStack.apply(stack), hrsgHPSteameEthalpy = (Double) popStack.apply(stack), ipSystemToColdReheatMassflow = (Double) popStack.apply(stack), ipSystemToColdReheatEnthalpy = (Double) popStack.apply(stack);
        Double stColdReheatMassflowTo11HRSG = (Double) popStack.apply(stack), stColdReheatEnthalpy = (Double) popStack.apply(stack), fgHTREnthalpy = (Double) popStack.apply(stack), fgHTRMassflow = (Double) popStack.apply(stack);
        Double fwEnthalpy = (Double) popStack.apply(stack), fwMassflow = (Double) popStack.apply(stack), hrsgCondensateEnthalpy = (Double) popStack.apply(stack), hrsgCondensateMassflow = (Double) popStack.apply(stack);
        List<Object> gainArr = new ArrayList<>();
        gainArr.add(hrsgCondensateMassflow);
        gainArr.add(hrsgCondensateEnthalpy);
        gainArr.add(fwMassflow);
        gainArr.add(fwEnthalpy);
        gainArr.add(fgHTRMassflow);
        gainArr.add(fgHTREnthalpy);
        gainArr.add(stColdReheatEnthalpy);
        gainArr.add(stColdReheatMassflowTo11HRSG);
        gainArr.add(ipSystemToColdReheatEnthalpy);
        gainArr.add(ipSystemToColdReheatMassflow);
        gainArr.add(hrsgHPSteameEthalpy);
        gainArr.add(hrsgHPSteamMassflow);
        gainArr.add(hrsgHRHSteamEnthalpy);
        gainArr.add(hrsgHRHSteamMassflow);
        gainArr.add(hrsgLPSteamEnthalpy);
        gainArr.add(hrsgLPSteamMassflow);
        double energyGain = hrsg_working_fluid_energy_gain.apply(gainArr);
        Double specificEnthalpyOfFuel77degF = (Double) popStack.apply(stack), specificEnthalpyOfFuelProcessTemperature = (Double) popStack.apply(stack), gtHVnet59degF = (Double) popStack.apply(stack);
        Double gtFuelNitrogenMolarFlow = (Double) popStack.apply(stack), gtDensity = (Double) popStack.apply(stack), reynoldsNumber = (Double) popStack.apply(stack), isopentane = (Double) popStack.apply(stack);
        Double pentane = (Double) popStack.apply(stack), isobutane = (Double) popStack.apply(stack), butane = (Double) popStack.apply(stack), propane = (Double) popStack.apply(stack), ethane = (Double) popStack.apply(stack);
        Double methane = (Double) popStack.apply(stack), nitrogen = (Double) popStack.apply(stack), gtGrossPowerTag = (Double) popStack.apply(stack), gasFlowRate = (Double) popStack.apply(stack);
        Double gtExhaustTemp = (Double) popStack.apply(stack), compTin = (Double) popStack.apply(stack), ambientRH = (Double) popStack.apply(stack), ambientP = (Double) popStack.apply(stack), ambientT = (Double) popStack.apply(stack);
        List<Object> inArr = new ArrayList<>();
        List<Object> outArr = new ArrayList<>();
        inArr.add(ambientT);
        inArr.add(ambientP);
        inArr.add(ambientRH);
        inArr.add(compTin);
        inArr.add(gtExhaustTemp);
        inArr.add(gasFlowRate);
        inArr.add(gtGrossPowerTag);
        inArr.add(nitrogen);
        inArr.add(methane);
        inArr.add(ethane);
        inArr.add(propane);
        inArr.add(butane);
        inArr.add(isobutane);
        inArr.add(pentane);
        inArr.add(isopentane);
        inArr.add(reynoldsNumber);
        inArr.add(gtDensity);
        inArr.add(gtFuelNitrogenMolarFlow);
        inArr.add(gtHVnet59degF);
        inArr.add(specificEnthalpyOfFuelProcessTemperature);
        inArr.add(specificEnthalpyOfFuel77degF);
        for(int i = 0; i < inArr.size(); i++) {
            outArr.add(inArr.get(i));
        }
        double energyIn = hrsg_energy_in.apply(inArr);
        double energyOut = hrsg_energy_out.apply(outArr);
        double efficiency = energyGain / (energyIn - energyOut);
        return changeRound(efficiency * 100);
    };
    // 필요 수식
    private static double chRatio(double methane, double ethane, double propane, double butane, double isobutane, double pentane, double isopentane) {
        double chRatio = ((methane * 1 + ethane * 2 + propane * 3 + butane * 4 + isobutane * 4 + pentane * 5 + isopentane * 5) * 12.011)
                / ((methane * 4 + ethane * 6 + propane * 8 + butane * 10 + isobutane * 10 + pentane * 12 + isopentane * 12) * 1.00794);
        return chRatio;
    };

    private static double gtMassFlow(double gasFlowRate, double reynoldsNumber, double gtDensity) {
        double gtFlowDeviationTestX1 = getIndex(calibrationResult().get("Re"), getMatch(reynoldsNumber, calibrationResult().get("Re"), 1));
        double gtFlowDeviationTestX2 = getIndex(calibrationResult().get("Re"), getMatch(reynoldsNumber, calibrationResult().get("Re"), 1) + 1);
        double gtFlowDeviationTestY1 = getIndex(calibrationResult().get("Deviation"), getMatch(reynoldsNumber, calibrationResult().get("Re"), 1));
        double gtFlowDeviationTestY2 = getIndex(calibrationResult().get("Deviation"), getMatch(reynoldsNumber, calibrationResult().get("Re"), 1) + 1);
        double gtFlowDeviation = gtFlowDeviationTestY1 + (reynoldsNumber - gtFlowDeviationTestX1) * (gtFlowDeviationTestY2 - gtFlowDeviationTestY1) / (gtFlowDeviationTestX2 - gtFlowDeviationTestX1);
        double gtCorrectedFuelFlowRate = gasFlowRate / (1 + gtFlowDeviation / 100);
        double gtMassFlow = gtCorrectedFuelFlowRate * gtDensity;
        return gtMassFlow;
    };

    private static Map<String, List<Number>> calibrationResult() {
        Map<String, List<Number>> resultMap = new HashMap<>();
        List<Number> qiQmaxArr = new ArrayList();
        qiQmaxArr.add(0.05);
        qiQmaxArr.add(0.1);
        qiQmaxArr.add(0.25);
        qiQmaxArr.add(0.4);
        qiQmaxArr.add(0.7);
        qiQmaxArr.add(1);
        resultMap.put("Qi/Qmax", qiQmaxArr);
        List<Number> qiArr = new ArrayList();
        qiArr.add(128.2);
        qiArr.add(248.5);
        qiArr.add(621.77);
        qiArr.add(1007.51);
        qiArr.add(1752.2);
        qiArr.add(2533.7);
        resultMap.put("Qi", qiArr);
        List<Number> reArr = new ArrayList();
        reArr.add(0.59);
        reArr.add(1.14);
        reArr.add(2.84);
        reArr.add(4.59);
        reArr.add(7.91);
        reArr.add(11.25);
        resultMap.put("Re", reArr);
        List<Number> deviationArr = new ArrayList();
        deviationArr.add(-0.01);
        deviationArr.add(0.03);
        deviationArr.add(-0.05);
        deviationArr.add(0.1);
        deviationArr.add(-0.01);
        deviationArr.add(-0.08);
        resultMap.put("Deviation", deviationArr);
        return resultMap;
    }

    private static double pOTCTestK(double ambientT) {
        double pOTCTestX = ambientT;
        List<Number> pOTCTestArr = new ArrayList<>();
        pOTCTestArr.add(-20);
        pOTCTestArr.add(-10);
        pOTCTestArr.add(0);
        pOTCTestArr.add(10);
        pOTCTestArr.add(15);
        pOTCTestArr.add(40); // 고정값
        double pOTCTestX1 = getIndex(pOTCTestArr, getMatch(pOTCTestX, pOTCTestArr, 1));
        double pOTCTestX2 = getIndex(pOTCTestArr, getMatch(pOTCTestX, pOTCTestArr, 1) + 1);
        List<Number> pOTCArr = new ArrayList<>();
        pOTCArr.add(4);
        pOTCArr.add(3);
        pOTCArr.add(1.6);
        pOTCArr.add(0.5);
        pOTCArr.add(0);
        pOTCArr.add(0);
        double pOTCTestY1 = getIndex(pOTCArr, getMatch(pOTCTestX, pOTCTestArr, 1));
        double pOTCTestY2 = getIndex(pOTCArr, getMatch(pOTCTestX, pOTCTestArr, 1) + 1);
        double pOTCTestK = pOTCTestY1 + (pOTCTestX - pOTCTestX1) * (pOTCTestY2 - pOTCTestY1) / (pOTCTestX2 - pOTCTestX1);
        return pOTCTestK;
    };

    private static double pGTEquivalentBoxHours(double gtEBH) {
        double pEBHTestX1 = getIndex(ltmpDegradation().get("t3_EBH"), getMatch(gtEBH, ltmpDegradation().get("t3_EBH"), 1));
        double pEBHTestX2 = getIndex(ltmpDegradation().get("t3_EBH"), getMatch(gtEBH, ltmpDegradation().get("t3_EBH"), 1) + 1);
        double pEBHTestY1 = getIndex(ltmpDegradation().get("t3_PDF"), getMatch(gtEBH, ltmpDegradation().get("t3_EBH"), 1));
        double pEBHTestY2 = getIndex(ltmpDegradation().get("t3_PDF"), getMatch(gtEBH, ltmpDegradation().get("t3_EBH"), 1) + 1);
        double pEBHTestX = gtEBH;
        double pGTEquivalentBoxHours = pEBHTestY1 + (pEBHTestX - pEBHTestX1) * (pEBHTestY2 - pEBHTestY1) / (pEBHTestX2 - pEBHTestX1);
        return pGTEquivalentBoxHours;
    };

    private static double hrGTEquivalentBoxHours(double gtEBH) {
        double hrEBHTestX1 = getIndex(ltmpDegradation().get("t4_EBH"), getMatch(gtEBH, ltmpDegradation().get("t4_EBH"), 1));
        double hrEBHTestX2 = getIndex(ltmpDegradation().get("t3_EBH"), getMatch(gtEBH, ltmpDegradation().get("t4_EBH"), 1) + 1);
        double hrEBHTestY1 = getIndex(ltmpDegradation().get("t4_PDF"), getMatch(gtEBH, ltmpDegradation().get("t4_EBH"), 1));
        double hrEBHTestY2 = getIndex(ltmpDegradation().get("t4_PDF"), getMatch(gtEBH, ltmpDegradation().get("t4_EBH"), 1) + 1);
        double hrEBHTestX = gtEBH;
        double hrGTEquivalentBoxHours = hrEBHTestY1 + (hrEBHTestX - hrEBHTestX1) * (hrEBHTestY2 - hrEBHTestY1) / (hrEBHTestX2 - hrEBHTestX1);
        return hrGTEquivalentBoxHours;
    };

    private static Map<String, List<Number>> ltmpDegradation() {
        Map<String, List<Number>> resultMap = new HashMap<>();
        List<Number> t3_EBH = new ArrayList();
        List<Number> t4_EBH = new ArrayList();
        t3_EBH.add(200);
        t4_EBH.add(200);
        int i = 1000;
        while(i <= 50000) {
            t3_EBH.add(i);
            t4_EBH.add(i);
            i += 1000;
        }
        resultMap.put("t3_EBH", t3_EBH);
        resultMap.put("t4_EBH", t4_EBH);
        List<Number> t3_PDF = new ArrayList();
        t3_PDF.add(1.0000);
        t3_PDF.add(0.9974);
        t3_PDF.add(0.9948);
        t3_PDF.add(0.9927);
        t3_PDF.add(0.9910);
        t3_PDF.add(0.9895);
        t3_PDF.add(0.9883);
        t3_PDF.add(0.9872);
        t3_PDF.add(0.9863);
        t3_PDF.add(0.9854);
        t3_PDF.add(0.9847);
        t3_PDF.add(0.9840);
        t3_PDF.add(0.9835);
        t3_PDF.add(0.9829);
        t3_PDF.add(0.9824);
        t3_PDF.add(0.9820);
        t3_PDF.add(0.9816);
        t3_PDF.add(0.9812);
        t3_PDF.add(0.9809);
        t3_PDF.add(0.9806);
        t3_PDF.add(0.9803);
        t3_PDF.add(0.9800);
        t3_PDF.add(0.9798);
        t3_PDF.add(0.9795);
        t3_PDF.add(0.9793);
        t3_PDF.add(0.9791);
        t3_PDF.add(0.9789);
        t3_PDF.add(0.9787);
        t3_PDF.add(0.9786);
        t3_PDF.add(0.9784);
        t3_PDF.add(0.9782);
        t3_PDF.add(0.9781);
        t3_PDF.add(0.9780);
        t3_PDF.add(0.9778);
        t3_PDF.add(0.9777);
        t3_PDF.add(0.9776);
        t3_PDF.add(0.9775);
        t3_PDF.add(0.9773);
        t3_PDF.add(0.9772);
        t3_PDF.add(0.9771);
        t3_PDF.add(0.9770);
        t3_PDF.add(0.9770);
        t3_PDF.add(0.9769);
        t3_PDF.add(0.9768);
        t3_PDF.add(0.9767);
        t3_PDF.add(0.9766);
        t3_PDF.add(0.9765);
        t3_PDF.add(0.9765);
        t3_PDF.add(0.9764);
        t3_PDF.add(0.9763);
        t3_PDF.add(0.9763);
        resultMap.put("t3_PDF", t3_PDF);
        List<Number> t4_PDF = new ArrayList();
        t4_PDF.add(1);
        t4_PDF.add(1.002);
        t4_PDF.add(1.003);
        t4_PDF.add(1.005);
        t4_PDF.add(1.006);
        t4_PDF.add(1.007);
        t4_PDF.add(1.008);
        t4_PDF.add(1.008);
        t4_PDF.add(1.009);
        t4_PDF.add(1.009);
        t4_PDF.add(1.01);
        t4_PDF.add(1.01);
        t4_PDF.add(1.011);
        t4_PDF.add(1.011);
        t4_PDF.add(1.011);
        t4_PDF.add(1.011);
        t4_PDF.add(1.012);
        t4_PDF.add(1.012);
        t4_PDF.add(1.012);
        t4_PDF.add(1.012);
        t4_PDF.add(1.012);
        t4_PDF.add(1.012);
        t4_PDF.add(1.013);
        t4_PDF.add(1.013);
        t4_PDF.add(1.013);
        t4_PDF.add(1.013);
        t4_PDF.add(1.013);
        t4_PDF.add(1.013);
        t4_PDF.add(1.013);
        t4_PDF.add(1.013);
        t4_PDF.add(1.013);
        t4_PDF.add(1.013);
        t4_PDF.add(1.013);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        t4_PDF.add(1.014);
        resultMap.put("t4_PDF", t4_PDF);
        return resultMap;
    }

    private static double pAdditiveCorrection(double gtGrossPowerTag, double stGrossPower, double gtPowerFactor) {
        double pAdditiveCorrection = -(2071.25714 + 1.32386288 * (gtGrossPowerTag + stGrossPower) + 0.000778400374 * Math.pow((gtGrossPowerTag + stGrossPower), 2)
                + 0.0000065121077 * Math.pow((gtGrossPowerTag + stGrossPower), 3))
                + (2071.24286 + 1.3193055 * (gtGrossPowerTag + stGrossPower) + 0.000224179308 * Math.pow((gtGrossPowerTag + stGrossPower), 2)
                + 0.00000644427324 * Math.pow((gtGrossPowerTag + stGrossPower), 3))
                - (1 - gtPowerFactor) / (1 - 0.95)
                * ((2071.24286 + 1.3193055 * (gtGrossPowerTag + stGrossPower) + 0.000224179308 * Math.pow((gtGrossPowerTag + stGrossPower), 2)
                + 0.00000644427324 * Math.pow((gtGrossPowerTag + stGrossPower), 3))
                - (2071.25714 + 1.32386288 * (gtGrossPowerTag + stGrossPower) + 0.000778400374 * Math.pow((gtGrossPowerTag + stGrossPower), 2)
                + 0.0000065121077 * Math.pow((gtGrossPowerTag + stGrossPower), 3)));
        return pAdditiveCorrection;
    };

    private static double pPowerCorrectionProduct(double ambientT, double ambientP, double ambientRH, double compTin, double compPin, double stCondenserP, double gasT, double stFrequency, double methane, double ethane, double propane, double butane, double isobutane, double pentane, double isopentane, double lhv) {
        List<Double> pPowerCorrectionProductArr = new ArrayList<>();
        double gtFilterDP = ambientP - compPin;
        double pAmbT;
        if (ambientT > -5) {
            pAmbT = 0.0000000000227947 * Math.pow(ambientT, 6) - 0.000000000904288 * Math.pow(ambientT, 5)
                    + 0.0000000116046 * Math.pow(ambientT, 4) + 0.00000153038 * Math.pow(ambientT, 3)
                    + 0.0000313905 * Math.pow(ambientT, 2) + 0.00173846 * (ambientT) + 0.962479;
        } else {
            pAmbT = 0.00006077479 * Math.pow(ambientT, 2) + 0.0005937187 * (ambientT) + 0.9617201;
        }
        double pAmbRHTestX = ambientRH - 60;
        double pAmbRHTestY = compTin;
        double pFuelAnalysisTestX = lhv - 49307.9;
        double pFuelAnalysisTestY = chRatio(methane, ethane, propane, butane, isobutane, pentane, isopentane);
        double pGridFrequencyTestX = stFrequency / 60;
        double pGridFrequencyTestY = compTin;
        double pAmbP = 0.000001208792 * Math.pow(ambientP - 1013, 2) - 0.0009982435 * (ambientP - 1013) + 1;
        double pAmbRH = 1 - 0.00003899067 * pAmbRHTestX + 0.000000399928 * Math.pow(pAmbRHTestX, 2) - 1.734723E-17 * pAmbRHTestY
                - 1.084202E-18 * Math.pow(pAmbRHTestY, 2) - 0.000000734811 * pAmbRHTestX * pAmbRHTestY + 0.00000006844623 * pAmbRHTestX * (2 * pAmbRHTestY)
                + 0.0000003040975 * pAmbRHTestX * Math.pow(pAmbRHTestY, 2)
                - 0.000000002054733 * Math.pow(pAmbRHTestX, 2) * Math.pow(pAmbRHTestY, 2);
        double PFuelT = -0.000000007423235 * (Math.pow(gasT - 15, 2)) - 0.000007852198 * (gasT - 15) + 1;
        double pFuelAnalysis = 0.9125875 + 0.00000101875 * pFuelAnalysisTestX - 0.000000000209375 * Math.pow(pFuelAnalysisTestX, 2) + 0.0435 * pFuelAnalysisTestY
                - 0.005 * Math.pow(pFuelAnalysisTestY, 2) - 0.000000125 * pFuelAnalysisTestX * pFuelAnalysisTestY + 0.0000000000625 * Math.pow(pFuelAnalysisTestX, 2) * pFuelAnalysisTestY
                + 4.336809E-19 * pFuelAnalysisTestX * Math.pow(pFuelAnalysisTestY, 2);
        double pGridFrequency = 1 + 0.004432362 * pGridFrequencyTestX + 0.00118746 * Math.pow(pGridFrequencyTestX, 2) + 3.469447E-18 * pGridFrequencyTestY
                + 2.168404E-19 * Math.pow(pGridFrequencyTestY, 2) - 0.00008495811 * pGridFrequencyTestX * pGridFrequencyTestY
                + 0.00005173638 * Math.pow(pGridFrequencyTestX, 2) * pGridFrequencyTestY - 0.0000289971 * pGridFrequencyTestX * Math.pow(pGridFrequencyTestY, 2)
                + 0.000007918523 * Math.pow(pGridFrequencyTestX, 2) * Math.pow(pGridFrequencyTestY, 2);
        double pGtInletPdrop = 0.001460719 * (gtFilterDP - 8) + 1;
        double pCondenserP = 0.000000000000352771 * Math.pow(stCondenserP * 1000 - 41.9, 6)
                - 0.0000000000645594 * Math.pow(stCondenserP * 1000 - 41.9, 5)
                + 0.00000000417418 * Math.pow(stCondenserP * 1000 - 41.9, 4) - 0.000000178082 * Math.pow(stCondenserP * 1000 - 41.9, 3)
                + 0.00000874248 * Math.pow(stCondenserP * 1000 - 41.9, 2) + 0.000369709 * (stCondenserP * 1000 - 41.9) + 1;
        pPowerCorrectionProductArr.add(pAmbT);
        pPowerCorrectionProductArr.add(pAmbP);
        pPowerCorrectionProductArr.add(pAmbRH);
        pPowerCorrectionProductArr.add(PFuelT);
        pPowerCorrectionProductArr.add(pFuelAnalysis);
        pPowerCorrectionProductArr.add(pGridFrequency);
        pPowerCorrectionProductArr.add(pGtInletPdrop);
        pPowerCorrectionProductArr.add(pCondenserP);
        double pPowerCorrectionProduct = getProduct(pPowerCorrectionProductArr);
        return pPowerCorrectionProduct;
    };

    private static double hrCorrectionProduct(double ambientT, double ambientP, double ambientRH, double compTin, double compPin, double stCondenserP, double gasT, double stFrequency) {
        List<Double> hrCorrctionProductArr = new ArrayList<>();
        double hrAmbT;

        if (ambientT < -2.5) {
            hrAmbT = 0.0000247122 * Math.pow(ambientT, 2) - 0.0004919713 * ambientT + 1.005837;
        } else {
            hrAmbT = -0.00000000000637832 * Math.pow(ambientT, 6) + 0.0000000000894723 * Math.pow(ambientT, 5)
                    + 0.0000000158761 * Math.pow(ambientT, 4) + 0.00000014839 * Math.pow(ambientT, 3)
                    + 0.0000220328 * Math.pow(ambientT, 2) - 0.000776154 * ambientT + 1.00564;
        }
        double hrAmbP = 0.0000002306463 * Math.pow((ambientP - 1013), 2) - 0.00001619771 * (ambientP - 1013) + 1;
        double hrAmbRHTestX = ambientRH - 60;
        double hrAmbRHTestY = compTin;
        double hrAmbRH = 1 + 0.000007228621 * hrAmbRHTestX + 0.0000004123121 * Math.pow(hrAmbRHTestX, 2) - 1.734723E-17 * hrAmbRHTestY
                - 1.084202E-18 * Math.pow(hrAmbRHTestY, 2) + 0.000002907698 * hrAmbRHTestX * hrAmbRHTestY
                + 0.00000006920143 * Math.pow(hrAmbRHTestX, 2) * hrAmbRHTestY + 0.0000002463781 * hrAmbRHTestX * Math.pow(hrAmbRHTestY, 2)
                - 0.000000002323444 * Math.pow(hrAmbRHTestX, 2) * Math.pow(hrAmbRHTestY, 2);
        double hrFuelT = 0.00000001846533 * Math.pow((gasT - 15), 2) + 0.00003493607 * gasT + 1;
        double hrFuelAnalysis = 1;
        double hrGridFrequencyTestX = stFrequency / 60;
        double hrGridFrequencyTestY = compTin;
        double hrGridFrequency = 1 + 0.001947536 * hrGridFrequencyTestX + 0.0008529767 * Math.pow(hrGridFrequencyTestX, 2) + 3.469447E-18 * hrGridFrequencyTestY
                + 2.168404E-19 * Math.pow(hrGridFrequencyTestY, 2) - 0.000124597 * hrGridFrequencyTestX * hrGridFrequencyTestY
                + 0.00001966455 * Math.pow(hrGridFrequencyTestX, 2) * hrGridFrequencyTestY - 0.000001528704 * hrGridFrequencyTestX * Math.pow(hrGridFrequencyTestY, 2)
                + 0.00000006724679 * Math.pow(hrGridFrequencyTestX, 2) * Math.pow(hrGridFrequencyTestY, 2);
        double gtFilterDP = ambientP - compPin;
        double hrGtInletPdrop = 0.0001600026 * (gtFilterDP - 8) + 1;
        double hrCondensorP = 0.000000000000356177 * Math.pow((stCondenserP * 1000 - 41.9), 6)
                - 0.0000000000650473 * Math.pow((stCondenserP * 1000 - 41.9), 5)
                + 0.00000000418965 * Math.pow((stCondenserP * 1000 - 41.9), 4) - 0.00000017802 * Math.pow((stCondenserP * 1000 - 41.9), 3)
                + 0.00000924954 * Math.pow((stCondenserP * 1000 - 41.9), 2) + 0.000369423 * (stCondenserP * 1000 - 41.9) + 1;
        hrCorrctionProductArr.add(hrAmbT);
        hrCorrctionProductArr.add(hrAmbP);
        hrCorrctionProductArr.add(hrAmbRH);
        hrCorrctionProductArr.add(hrFuelT);
        hrCorrctionProductArr.add(hrFuelAnalysis);
        hrCorrctionProductArr.add(hrGridFrequency);
        hrCorrctionProductArr.add(hrGtInletPdrop);
        hrCorrctionProductArr.add(hrCondensorP);
        double hrCorrectionProduct = getProduct(hrCorrctionProductArr);
        return hrCorrectionProduct;
    };

    private static double stEnergyInSTEnergyOut(double steamFromHPBoiler1F, double steamFromHRHBoiler1F, double steamFromLPBoiler1F, double stGrossPower, double steamFromHPBoiler1H, double steamToCRHBoiler1H, double steamFromHRHBoiler1H, double steamFromLPBoiler1H, double condensateWaterToCondensorH, double condensateWaterF) {
        double cSteamFromHPBoiler1F = steamFromHPBoiler1F;
        double energyInFromHPBoiler = (steamFromHPBoiler1H * cSteamFromHPBoiler1F) / 1000;
        double cSteamToCRHBoiler1F = steamFromHPBoiler1F;
        double energyOutToCRHBoiler = -steamToCRHBoiler1H / 1000 * (cSteamToCRHBoiler1F);
        double cSteamFromHRHBoiler1F = steamFromHRHBoiler1F;
        double energyInFromHRHBoiler = (steamFromHRHBoiler1H * cSteamFromHRHBoiler1F) / 1000;
        double cSteamFromLPBoiler1F = steamFromLPBoiler1F;
        double energyInFromLPBoiler = steamFromLPBoiler1H / 1000 * (cSteamFromLPBoiler1F);
        double energyOutToCondensorPreHeater = -condensateWaterToCondensorH * condensateWaterF / 1000;
        double stEnergyInSTEnergyOut = (energyInFromHPBoiler + energyInFromHRHBoiler + energyInFromLPBoiler) + (energyOutToCRHBoiler + energyOutToCondensorPreHeater) - stGrossPower;
        return stEnergyInSTEnergyOut;
    };

    private static double pH2O(double ambientT, double ambientRH) {
        double dryBulTemperatureDegF = ambientT * 9 / 5 + 32;
        double H20 = -10214.165;
        double H21 = -4.8932428;
        double H22 = -0.0053765794;
        double H23 = 0.00000019202377;
        double H24 = 0.00000000035575832;
        double H25 = -9.0344688E-14;
        double H26 = 4.1635019;
        double H27 = -10440.397;
        double H28 = -11.29465;
        double H29 = -0.027022355;
        double H30 = 0.00001289036;
        double H31 = -0.0000000024780681;
        double H32 = 0; // 소수자리 늘려도 값이 없음
        double H33 = 6.5459673;
        double wetBulbTempDegFOrRelativeHumidity = ambientRH;
        double pVapor;
        if (dryBulTemperatureDegF < 32) {
            double H18 = H20 / (dryBulTemperatureDegF + 459.67) + H21 + H22 * (dryBulTemperatureDegF + 459.67) + H23 * Math.pow((dryBulTemperatureDegF + 459.67), 2)
                    + H24 * Math.pow((dryBulTemperatureDegF + 459.67), 3) + H25 * Math.pow((dryBulTemperatureDegF + 459.67), 4)
                    + H26 * Math.log(dryBulTemperatureDegF + 459.67);
            pVapor = Math.exp(H18);
        } else {
            double H19 = H27 / (dryBulTemperatureDegF + 459.67) + H28 + H29 * (dryBulTemperatureDegF + 459.67) + H30 * Math.pow((dryBulTemperatureDegF + 459.67), 2)
                    + H31 * Math.pow((dryBulTemperatureDegF + 459.67), 3) + H32 * Math.pow((dryBulTemperatureDegF + 459.67), 4)
                    + H33 * Math.log(dryBulTemperatureDegF + 459.67);
            pVapor = Math.exp(H19);
        }
        double pH2O = pVapor * wetBulbTempDegFOrRelativeHumidity / 100;
        return pH2O;
    };

    private static double fractionOfDryAir(double ambientT, double ambientP, double ambientRH) {
        double barometricPressurePsia = ambientP * 0.0145038;
        double fractionOfDryAir = (barometricPressurePsia - pH2O(ambientT, ambientRH)) / barometricPressurePsia;
        return fractionOfDryAir;
    };

    private static double humidityRatio(double ambientT, double ambientP, double ambientRH) {
        double humidityRatio = (1 / fractionOfDryAir(ambientT, ambientP, ambientRH) - 1) * 18.01528 / 28.9651159;
        return humidityRatio;
    };

    private static double nitrogenMoleFraction(double ambientT, double ambientP, double ambientRH) {
        double nitrogenMoleFraction = fractionOfDryAir(ambientT, ambientP, ambientRH) * 0.78084 * 100;
        return nitrogenMoleFraction;
    };

    private static double oxygenMoleFraction(double ambientT, double ambientP, double ambientRH) {
        double oxygenMoleFraction = fractionOfDryAir(ambientT, ambientP, ambientRH) * 0.209476 * 100;
        return oxygenMoleFraction;
    };

    private static double argonMoleFraction(double ambientT, double ambientP, double ambientRH) {
        double argonMoleFraction = fractionOfDryAir(ambientT, ambientP, ambientRH) * 0.009365 * 100;
        return argonMoleFraction;
    };

    private static double carbonMoleFraction(double ambientT, double ambientP, double ambientRH) {
        double carbonMoleFraction = fractionOfDryAir(ambientT, ambientP, ambientRH) * 0.000319 * 100;
        return carbonMoleFraction;
    };

    private static double waterMoleFraction(double ambientT, double ambientP, double ambientRH) {
        double waterMoleFraction = (1 - fractionOfDryAir(ambientT, ambientP, ambientRH)) * 100;
        return waterMoleFraction;
    };


    private static double molecularWeight(double ambientT, double ambientP, double ambientRH) {
        double molecularWeight = nitrogenMoleFraction(ambientT, ambientP, ambientRH) * (14.0067 * 2) + oxygenMoleFraction(ambientT, ambientP, ambientRH) * (15.9994 * 2) + argonMoleFraction(ambientT, ambientP, ambientRH) * 39.948
                + carbonMoleFraction(ambientT, ambientP, ambientRH) * (12.0107 + 15.9994 * 2) + waterMoleFraction(ambientT, ambientP, ambientRH) * (1.00794 * 2 + 15.9994);
        return molecularWeight;
    };


    private static double mFN2(double ambientT, double ambientP, double ambientRH) {
        double mFN2 = nitrogenMoleFraction(ambientT, ambientP, ambientRH) * (14.0067 * 2) / molecularWeight(ambientT, ambientP, ambientRH);
        return mFN2;
    };


    private static double mFO2(double ambientT, double ambientP, double ambientRH) {
        double mFO2 = oxygenMoleFraction(ambientT, ambientP, ambientRH) * (15.9994 * 2) / molecularWeight(ambientT, ambientP, ambientRH);
        return mFO2;
    };


    private static double mFCo2(double ambientT, double ambientP, double ambientRH) {
        double mFCo2 = carbonMoleFraction(ambientT, ambientP, ambientRH) * (12.0107 + 15.9994 * 2) / molecularWeight(ambientT, ambientP, ambientRH);
        return mFCo2;
    };


    private static double mFAr2(double ambientT, double ambientP, double ambientRH) {
        double mFAr2 = argonMoleFraction(ambientT, ambientP, ambientRH) * 39.948 / molecularWeight(ambientT, ambientP, ambientRH);
        return mFAr2;
    };


    private static double mFH2O(double ambientT, double ambientP, double ambientRH) {
        double mFH2O = waterMoleFraction(ambientT, ambientP, ambientRH) * (1.00794 * 2 + 15.9994) / molecularWeight(ambientT, ambientP, ambientRH);
        return mFH2O;
    };

    private static double gtMAirCombDry(double gasFlowRate, double nitrogen, double methane, double ethane, double propane, double butane, double isobutane, double pentane, double isopentane, double reynoldsNumber, double gtDensity) {
        double pNitrogen = nitrogen / 100; // 백분율이 아니기 때문에 100으로 나눔
        double pMethane = methane / 100;
        double pEthane = ethane / 100;
        double pPropane = propane / 100;
        double pButane = butane / 100;
        double pIsobutane = isobutane / 100;
        double pPentane = pentane / 100;
        double pIsopentane = isopentane / 100;
        double molacularWeightFuel = 17.3741;
        double gtFuelMolarFlow = gtFuelGasFlow(gasFlowRate, reynoldsNumber, gtDensity) / molacularWeightFuel;
        double gtO2MolarFlowChange = -gtFuelMolarFlow * (pNitrogen * 0 + pMethane * 2 + pEthane * 3.5 + pPropane * 5 + pIsobutane * 6.5 + pButane * 6.5 + pIsopentane * 8 + pPentane * 8);
        double H116 = gtO2MolarFlowChange;
        double gtMAirCombDry = -H116 / 0.209476 * 28.9651159;
        return gtMAirCombDry;
    };

    private static double step1GTMAirComb(double ambientT, double ambientP, double ambientRH, double gasFlowRate, double nitrogen, double methane, double ethane, double propane, double butane, double isobutane, double pentane, double isopentane, double reynoldsNumber, double gtDensity) {
        double step1GTMAirComb = gtMAirCombDry(gasFlowRate, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity) * (1 + humidityRatio(ambientT, ambientP, ambientRH));
        return step1GTMAirComb;
    };

    private static double step2GTMAirComb(double ambientT, double ambientP, double ambientRH, double gasFlowRate, double nitrogen, double methane, double ethane, double propane, double butane, double isobutane, double pentane, double isopentane, double reynoldsNumber, double gtDensity) {
        double step2GTMAirComb = gtMAirCombDry(gasFlowRate, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity) * (1 + humidityRatio(ambientT, ambientP, ambientRH));
        return step2GTMAirComb;
    };

    private static double gtFuelGasFlow(double gasFlowRate, double reynoldsNumber, double gtDensity) {
        double gtFuelGasFlow = gtMassFlow(gasFlowRate, reynoldsNumber, gtDensity) * 2.20462;
        return gtFuelGasFlow;
    };

    private static double gtMcombprod(double ambientT, double ambientP, double ambientRH, double gasFlowRate, double nitrogen, double methane, double ethane, double propane, double butane, double isobutane, double pentane, double isopentane, double reynoldsNumber, double gtDensity) {
        double gtSteamInjection = 0;
        double gtMcombprod = step2GTMAirComb(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity) + gtSteamInjection + gtFuelGasFlow(gasFlowRate, reynoldsNumber, gtDensity);
        return gtMcombprod;
    };


    private static double gtNitrogen(double ambientT, double ambientP, double ambientRH, double gasFlowRate, double nitrogen, double methane, double ethane, double propane, double butane, double isobutane, double pentane, double isopentane, double reynoldsNumber, double gtDensity,
                                 double gtFuelNitrogenMolarFlow) {
        double gtMN2 = step1GTMAirComb(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity) * nitrogenMoleFraction(ambientT, ambientP, ambientRH) / molecularWeight(ambientT, ambientP, ambientRH);
        double gtMAirN2 = gtMN2;
        double molacularWeightFuel = 17.3741;
        double gtFuelMolarFlow = gtFuelGasFlow(gasFlowRate, reynoldsNumber, gtDensity) / molacularWeightFuel;
        double gtN2MolarFlowChange = gtFuelMolarFlow * gtFuelNitrogenMolarFlow * 1;
        double changeInMolarFlowOfNitrogenDueToCombustion = gtN2MolarFlowChange;
        double gtMcombprodN2 = gtMAirN2 + changeInMolarFlowOfNitrogenDueToCombustion;
        double gtMFcombprodN2 = gtMcombprodN2 * (14.0067 * 2) / gtMcombprod(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity);
        double gtNitrogen = gtMFcombprodN2;
        return gtNitrogen;
    };

    private static double gtOxygen(double ambientT, double ambientP, double ambientRH, double gasFlowRate, double nitrogen, double methane, double ethane, double propane, double butane, double isobutane, double pentane, double isopentane, double reynoldsNumber, double gtDensity) {
        double gtMO2 = step1GTMAirComb(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity) * oxygenMoleFraction(ambientT, ambientP, ambientRH) / molecularWeight(ambientT, ambientP, ambientRH);
        double gtMAirO2 = gtMO2;
        double molacularWeightFuel = 17.3741;
        double gtFuelMolarFlow = gtFuelGasFlow(gasFlowRate, reynoldsNumber, gtDensity) / molacularWeightFuel;
        double pNitrogen = nitrogen / 100; // H는 1이 100%이기 때문에 100으로 나눠줌
        double pMethane = methane / 100;
        double pEthane = ethane / 100;
        double pPropane = propane / 100;
        double pButane = butane / 100;
        double pIsobutane = isobutane / 100;
        double pPentane = pentane / 100;
        double pIsopentane = isopentane / 100;
        double gtO2MolarFlowChange = -gtFuelMolarFlow * (pNitrogen * 0 + pMethane * 2 + pEthane * 3.5 + pPropane * 5 + pIsobutane * 6.5 + pButane * 6.5 + pIsopentane * 8 + pPentane * 8);
        double changeInMolarFlowOfOxygenDueToCombustion = gtO2MolarFlowChange;
        double gtMcombprodO2 = gtMAirO2 + changeInMolarFlowOfOxygenDueToCombustion;
        double gtMFcombprodO2 = gtMcombprodO2 * (15.9994 * 2) / gtMcombprod(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity);
        double gtOxygen = gtMFcombprodO2;
        return gtOxygen;
    };

    private static double gtCarbonDioxide(double ambientT, double ambientP, double ambientRH, double gasFlowRate, double nitrogen, double methane, double ethane, double propane, double butane, double isobutane, double pentane, double isopentane, double reynoldsNumber, double gtDensity) {
        double gtMCO2 = step1GTMAirComb(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity) * carbonMoleFraction(ambientT, ambientP, ambientRH) / molecularWeight(ambientT, ambientP, ambientRH);
        double molacularWeightFuel = 17.3741;
        double gtFuelMolarFlow = gtFuelGasFlow(gasFlowRate, reynoldsNumber, gtDensity) / molacularWeightFuel;
        double pNitrogen = nitrogen / 100; // H는 1이 100%이기 때문에 100으로 나눠줌
        double pMethane = methane / 100;
        double pEthane = ethane / 100;
        double pPropane = propane / 100;
        double pButane = butane / 100;
        double pIsobutane = isobutane / 100;
        double pPentane = pentane / 100;
        double pIsopentane = isopentane / 100;
        double gtCO2MolarFlowChange = gtFuelMolarFlow * (pNitrogen * 0 + pMethane * 1 + pEthane * 2 + pPropane * 3 + pIsobutane * 4 + pButane * 4 + pIsopentane * 5 + pPentane * 5);
        double gtMAirCO2 = gtMCO2;
        double changeInMolarFlowOfCarbonDueToCombustion = gtCO2MolarFlowChange;
        double gtMcombprodCO2 = gtMAirCO2 + changeInMolarFlowOfCarbonDueToCombustion;
        double gtMFcombprodCO2 = gtMcombprodCO2 * (12.0107 + 15.9994 * 2) / gtMcombprod(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity);
        double gtCarbonDioxide = gtMFcombprodCO2;
        return gtCarbonDioxide;
    };

    private static double gtArgon(double ambientT, double ambientP, double ambientRH, double gasFlowRate, double nitrogen, double methane, double ethane, double propane, double butane, double isobutane, double pentane, double isopentane, double reynoldsNumber, double gtDensity) {
        double gtMAr = step1GTMAirComb(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity) * argonMoleFraction(ambientT, ambientP, ambientRH) / molecularWeight(ambientT, ambientP, ambientRH);
        double gtMAirAr = gtMAr;
        double changeInMolarFlowOfCarbonDioxideDueToCombustion = 0; // 엑셀에 값이 없음
        double gtMcombprodAr = gtMAirAr + changeInMolarFlowOfCarbonDioxideDueToCombustion;
        double gtMFcombprodAr = gtMcombprodAr * (39.948) / gtMcombprod(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity);
        double gtArgon = gtMFcombprodAr;
        return gtArgon;
    };

    private static double gtWater(double ambientT, double ambientP, double ambientRH, double gasFlowRate, double nitrogen, double methane, double ethane, double propane, double butane, double isobutane, double pentane, double isopentane, double reynoldsNumber, double gtDensity) {
        double gtMH2O = step1GTMAirComb(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity) * waterMoleFraction(ambientT, ambientP, ambientRH) / molecularWeight(ambientT, ambientP, ambientRH);
        double gtMMAirH2O = gtMH2O;
        double molacularWeightFuel = 17.3741;
        double pNitrogen = nitrogen / 100; // H는 1이 100%이기 때문에 100으로 나눠줌
        double pMethane = methane / 100;
        double pEthane = ethane / 100;
        double pPropane = propane / 100;
        double pButane = butane / 100;
        double pIsobutane = isobutane / 100;
        double pPentane = pentane / 100;
        double pIsopentane = isopentane / 100;
        double gtFuelMolarFlow = gtFuelGasFlow(gasFlowRate, reynoldsNumber, gtDensity) / molacularWeightFuel;
        double gtH2OMolarFlowChange = gtFuelMolarFlow * (pNitrogen * 0 + pMethane * 2 + pEthane * 3 + pPropane * 4 + pIsobutane * 5 + pButane * 5 + pIsopentane * 6 + pPentane * 6);
        double gtSteamInjection = 0;
        double changeInMolarFlowOfWaterDueToCombustion = gtH2OMolarFlowChange + gtSteamInjection / 18.01528;
        double gtMcombprodH2O = gtMMAirH2O + changeInMolarFlowOfWaterDueToCombustion;
        double gtMFcombprodH2O = gtMcombprodH2O * (1.00794 * 2 + 15.9994) / gtMcombprod(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity);
        double gtWater = gtMFcombprodH2O;
        return gtWater;
    };

    private static double gtHaOut(double ambientT, double ambientP, double ambientRH, double gtExhaustTemp) {
        List<Double> gt11Arr = new ArrayList<>();
        gt11Arr.add(mFN2(ambientT, ambientP, ambientRH));
        gt11Arr.add(mFO2(ambientT, ambientP, ambientRH));
        gt11Arr.add(mFCo2(ambientT, ambientP, ambientRH));
        gt11Arr.add(mFAr2(ambientT, ambientP, ambientRH));
        gt11Arr.add(mFH2O(ambientT, ambientP, ambientRH));
        double gtHAOutNitrogen = gtHResult(gtExhaustTemp, "n2");
        double gtHAOutOxygen = gtHResult(gtExhaustTemp, "o2");
        double gtHAOutCarbonDioxide = gtHResult(gtExhaustTemp, "co2");
        double gtHAOutArgon = gtHResult(gtExhaustTemp, "ar");
        double gtHAOutWater = gtHResult(gtExhaustTemp, "h2o");
        List<Number> airArr = new ArrayList<>();
        airArr.add(gtHAOutNitrogen);
        airArr.add(gtHAOutOxygen);
        airArr.add(gtHAOutCarbonDioxide);
        airArr.add(gtHAOutArgon);
        airArr.add(gtHAOutWater);
        double gtHaOut = getSumArr(gt11Arr, airArr);
        return gtHaOut;
    };

    private static double gtHgOut(double ambientT, double ambientP, double ambientRH, double gtExhaustTemp, double gasFlowRate,
                                  double nitrogen, double methane, double ethane, double propane, double butane, double isobutane,
                                  double pentane, double isopentane, double reynoldsNumber, double gtDensity, double gtFuelNitrogenMolarFlow) {
        List<Double> gt11Arr = new ArrayList<>();
        gt11Arr.add(gtNitrogen(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane,
                isobutane, pentane, isopentane, reynoldsNumber, gtDensity, gtFuelNitrogenMolarFlow));
        gt11Arr.add(gtOxygen(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane,
                isobutane, pentane, isopentane, reynoldsNumber, gtDensity));
        gt11Arr.add(gtCarbonDioxide(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane,
                butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity));
        gt11Arr.add(gtArgon(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane,
                isobutane, pentane, isopentane, reynoldsNumber, gtDensity));
        gt11Arr.add(gtWater(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane, butane,
                isobutane, pentane, isopentane, reynoldsNumber, gtDensity));
        double gtHGOutNitrogen = gtHResult(gtExhaustTemp, "n2");
        double gtHGOutOxygen = gtHResult(gtExhaustTemp, "o2");
        double gtHGOutCarbonDioxide = gtHResult(gtExhaustTemp, "co2");
        double gtHGOutArgon = gtHResult(gtExhaustTemp, "ar");
        double gtHGOutWater = gtHResult(gtExhaustTemp, "h2o");
        List<Number> airArr = new ArrayList<>();
        airArr.add(gtHGOutNitrogen);
        airArr.add(gtHGOutOxygen);
        airArr.add(gtHGOutCarbonDioxide);
        airArr.add(gtHGOutArgon);
        airArr.add(gtHGOutWater);
        double gtHgOut = getSumArr(gt11Arr, airArr);
        return gtHgOut;
    };

    private static double hrsgMassFlowOfBalanceOfAir(double ambientT, double ambientP, double ambientRH, double compTin,
                                                     double gtExhaustTemp, double gasFlowRate, double gtGrossPowerTag, double nitrogen, double methane, double ethane,
                                                     double propane, double butane, double isobutane, double pentane, double isopentane, double reynoldsNumber,
                                                     double gtDensity, double gtFuelNitrogenMolarFlow, double gtHVnet59degF, double specificEnthalpyOfFuelProcessTemperature,
                                                     double specificEnthalpyOfFuel77degF) {
        double gtPowerOutput = gtGrossPowerTag * 3412141.16;
        List<Double> gt11Arr = new ArrayList<>();
        gt11Arr.add(mFN2(ambientT, ambientP, ambientRH));
        gt11Arr.add(mFO2(ambientT, ambientP, ambientRH));
        gt11Arr.add(mFCo2(ambientT, ambientP, ambientRH));
        gt11Arr.add(mFAr2(ambientT, ambientP, ambientRH));
        gt11Arr.add(mFH2O(ambientT, ambientP, ambientRH));
        double gtHAInNitrogen = gtHResult(compTin, "n2");
        double gtHAInOxygen = gtHResult(compTin, "o2");
        double gtHAInCarbonDioxide = gtHResult(compTin, "co2");
        double gtHAInArgon = gtHResult(compTin, "ar");
        double gtHAInWater = gtHResult(compTin, "h2o");
        List<Number> airArr = new ArrayList<>();
        airArr.add(gtHAInNitrogen);
        airArr.add(gtHAInOxygen);
        airArr.add(gtHAInCarbonDioxide);
        airArr.add(gtHAInArgon);
        airArr.add(gtHAInWater);
        double gtHaIn = getSumArr(gt11Arr, airArr);
        double gtHVnetFlowingCondition = gtHVnet59degF + specificEnthalpyOfFuelProcessTemperature
                - specificEnthalpyOfFuel77degF;
        double gtWgtfHVnet = gtHVnetFlowingCondition * gtFuelGasFlow(gasFlowRate, reynoldsNumber, gtDensity);
        double gtQhl = gtPowerOutput * 0.027;
        double gtWba = (gtPowerOutput + gtQhl + step2GTMAirComb(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen,
                methane, ethane, propane, butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity)
                * gtHgOut(ambientT, ambientP, ambientRH, gtExhaustTemp, gasFlowRate, nitrogen, methane, ethane, propane, butane,
                isobutane, pentane, isopentane, reynoldsNumber, gtDensity, gtFuelNitrogenMolarFlow)
                + gtFuelGasFlow(gasFlowRate, reynoldsNumber, gtDensity) * gtHgOut(ambientT, ambientP, ambientRH, gtExhaustTemp,
                gasFlowRate, nitrogen, methane, ethane, propane, butane, isobutane, pentane, isopentane,
                reynoldsNumber, gtDensity, gtFuelNitrogenMolarFlow)
                - (step2GTMAirComb(ambientT, ambientP, ambientRH, gasFlowRate, nitrogen, methane, ethane, propane,
                butane, isobutane, pentane, isopentane, reynoldsNumber, gtDensity) * gtHaIn + gtWgtfHVnet))
                / (gtHaIn - gtHaOut(ambientT, ambientP, ambientRH, gtExhaustTemp));
        return gtWba;
    };

    private static double gtHResult(double inTemp, String property) {
        double gtTemp = inTemp * 9 / 5 + 32;
        double temp = (gtTemp + 459.67 ) / 1.8;
        double result = ((-getGlennCoefficient().get(property).get(0)
                / temp + getGlennCoefficient().get(property).get(1)
                * Math.log(temp) + getGlennCoefficient().get(property).get(2)
                * temp + getGlennCoefficient().get(property).get(3)
                * Math.pow(temp, 2) / 2 + getGlennCoefficient().get(property).get(4)
                * Math.pow(temp, 3) / 3 + getGlennCoefficient().get(property).get(5)
                * Math.pow(temp, 4) / 4 + getGlennCoefficient().get(property).get(6)
                * Math.pow(temp, 5) / 5 + getGlennCoefficient().get(property).get(7))
                * 8.31451 - getGlennCoefficient().get(property).get(8))
                / getGlennCoefficient().get(property).get(9) / 2.326;
        return result;
    };

    private static Map<String, List<Double>> getGlennCoefficient() {
        Map<String, List<Double>> resultMap = new HashMap<>();
        List<Double> n2 = new ArrayList();
        n2.add(22103.715);
        n2.add(-381.846182);
        n2.add(6.08273836);
        n2.add(-0.008530914);
        n2.add(1.38E-05);
        n2.add(-9.63E-09);
        n2.add(2.52E-12);
        n2.add(7.11E+02);
        n2.add(0.00E+00);
        n2.add(2.80E+01);
        resultMap.put("n2", n2);
        List<Double> o2 = new ArrayList();
        o2.add(-34255.6342);
        o2.add(484.700097);
        o2.add(1.11901096);
        o2.add(0.004293889);
        o2.add(-6.84E-07);
        o2.add(-2.02E-09);
        o2.add(1.04E-12);
        o2.add(-3.39E+03);
        o2.add(0.00E+00);
        o2.add(3.20E+01);
        resultMap.put("o2", o2);
        List<Double> co2 = new ArrayList();
        co2.add(49436.5054);
        co2.add(-626.411601);
        co2.add(5.30172524);
        co2.add(0.002503814);
        co2.add(-2.13E-07);
        co2.add(-7.69E-10);
        co2.add(2.85E-13);
        co2.add(-4.53E+04);
        co2.add(-3.94E+05);
        co2.add(4.40E+01);
        resultMap.put("co2", co2);
        List<Double> ar = new ArrayList();
        ar.add((double) 0);
        ar.add((double) 0);
        ar.add(2.5);
        ar.add((double) 0);
        ar.add((double) 0);
        ar.add((double) 0);
        ar.add((double) 0);
        ar.add(-7.45E+02);
        ar.add((double) 0);
        ar.add(3.99E+01);
        resultMap.put("ar", ar);
        List<Double> h2o = new ArrayList();
        h2o.add(-39479.6083);
        h2o.add(575.573102);
        h2o.add(0.931782653);
        h2o.add(0.007222713);
        h2o.add(-7.34E-06);
        h2o.add(4.96E-09);
        h2o.add(-1.34E-12);
        h2o.add(-3.30E+04);
        h2o.add(-2.42E+05);
        h2o.add(1.80E+01);
        resultMap.put("h2o", h2o);
        return resultMap;
    };

    // product(arr) arr의 각 값들을 전부 곱함
    private static double getProduct(List<Double> list) {
        double temp = 1;
        for (int i = 0; i < list.size(); i++) {
            temp *= Double.parseDouble(list.get(i).toString());
        }
        return temp;
    };

    // {sum(arr_1 : arr_2)} 두 배열에서 각 인덱스에 해당하는 값을 곱한 뒤 전부 더함
    private static double getSumArr(List arr_1, List arr_2) {
        double temp = 0;
        for (int i = 0; i < arr_1.size(); i++) {
            temp += Double.parseDouble(arr_1.get(i).toString()) * Double.parseDouble(arr_2.get(i).toString());
        }
        return temp;
    };

    // index(arr, row_num) arr에서 해당 index(row_num)의 값을 찾음
    private static double getIndex(List<Number> arr, int rowNum) {
        return Double.parseDouble(arr.get(rowNum - 1).toString());
    };

    // match(lookup_value, lookup_arr, match_type(-1, 0, 1)) 찾을 값(lookup_value)이 lookup_arr의 몇 번째 index인지 찾음
    private static int getMatch(double lookUpValue, List<Number> arr, int matchType) {
        int idx = 0;
        if (matchType == 1) { // 오름차순 정렬
            for (int i = 0; i < arr.size(); i++) {
                if (Double.parseDouble(arr.get(i).toString()) > lookUpValue) {
                    idx = i;
                    break;
                }
            }
        } else if (matchType == 0) { // 정렬 상관없음
            for (int i = 0; i < arr.size(); i++) {
                if (Double.parseDouble(arr.get(i).toString()) == lookUpValue) {
                    idx = i + 1;
                    break;
                }
            }
        } else { // 내림차순 정렬
            for (int i = 0; i < arr.size(); i++) {
                if (Double.parseDouble(arr.get(i).toString()) < lookUpValue) {
                    idx = i;
                    break;
                }
            }
        }
        return idx;
    };

    // 소수점 2자리 반올림 표현
    private static double changeRound(double value) {
        String num = String.format("%.2f", value);
        return Double.parseDouble(num);
	};

}
