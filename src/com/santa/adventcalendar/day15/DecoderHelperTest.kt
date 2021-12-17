package com.santa.adventcalendar.day15

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class DecoderHelperTest {
    @Test
    fun hexToBinaryTest() {
        val helper = DecoderHelper()
        val binary = helper.hexToBinary("CF")
        assertArrayEquals(binary,arrayOf(1,1,0,0,1,1,1,1))
    }

    @Test
    fun headerPacketTest() {
        val helper = DecoderHelper()
        val binary = helper.parseBinary("110100101111111000101000")
        val packet = helper.getPacket(binary)
        packet as ValuePacket
        assertEquals(6, packet.version)
        assertEquals(4, packet.type)
        assertEquals(2021, packet.value)

    }

    @Test
    fun operatorPacketTest() {
        val hex = "38006F45291200"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        assertEquals(1, packet.version)
        assertEquals(6, packet.type)
        assertEquals(2, packet.subPackets.size)

    }

    @Test
    fun thirdExampleTest() {
        val hex = "EE00D40C823060"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        assertEquals(7, packet.version)
        assertEquals(3, packet.type)
        assertEquals(3, packet.subPackets.size)

    }

    @Test
    fun addVersionsTest() {
        val hex = "8A004A801A8002F478"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        val total = helper.addVersions(packet)
        assertEquals(16, total)
    }

    @Test
    fun addVersionsSecondTest() {
        val hex = "620080001611562C8802118E34"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        val total = helper.addVersions(packet)
        assertEquals(12, total)

    }

    @Test
    fun addVersionThirdTest() {
        val hex = "C0015000016115A2E0802F182340"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        val total = helper.addVersions(packet)
        assertEquals(23, total)

    }

    @Test
    fun addVersionFourthTest() {
        val hex = "A0016C880162017C3686B18A3D4780"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        val total = helper.addVersions(packet)
        assertEquals(31, total)
    }

    @Test
    fun addVersionFinalTest() {
        val hex = "A052E04CFD9DC0249694F0A11EA2044E200E9266766AB004A525F86FFCDF4B25DFC401A20043A11C61838600FC678D51B8C0198910EA1200010B3EEA40246C974EF003331006619C26844200D414859049402D9CDA64BDEF3C4E623331FBCCA3E4DFBBFC79E4004DE96FC3B1EC6DE4298D5A1C8F98E45266745B382040191D0034539682F4E5A0B527FEB018029277C88E0039937D8ACCC6256092004165D36586CC013A008625A2D7394A5B1DE16C0E3004A8035200043220C5B838200EC4B8E315A6CEE6F3C3B9FFB8100994200CC59837108401989D056280803F1EA3C41130047003530004323DC3C860200EC4182F1CA7E452C01744A0A4FF6BBAE6A533BFCD1967A26E20124BE1920A4A6A613315511007A4A32BE9AE6B5CAD19E56BA1430053803341007E24C168A6200D46384318A6AAC8401907003EF2F7D70265EFAE04CCAB3801727C9EC94802AF92F493A8012D9EABB48BA3805D1B65756559231917B93A4B4B46009C91F600481254AF67A845BA56610400414E3090055525E849BE8010397439746400BC255EE5362136F72B4A4A7B721004A510A7370CCB37C2BA0010D3038600BE802937A429BD20C90CCC564EC40144E80213E2B3E2F3D9D6DB0803F2B005A731DC6C524A16B5F1C1D98EE006339009AB401AB0803108A12C2A00043A134228AB2DBDA00801EC061B080180057A88016404DA201206A00638014E0049801EC0309800AC20025B20080C600710058A60070003080006A4F566244012C4B204A83CB234C2244120080E6562446669025CD4802DA9A45F004658527FFEC720906008C996700397319DD7710596674004BE6A161283B09C802B0D00463AC9563C2B969F0E080182972E982F9718200D2E637DB16600341292D6D8A7F496800FD490BCDC68B33976A872E008C5F9DFD566490A14"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        val total = helper.addVersions(packet)
        assertEquals(879, total)
    }

    @Test
    fun sumTest() {
        val hex = "C200B40A82"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        val total = helper.evaluate(packet)
        assertEquals(3, total)
    }

    @Test
    fun productTest() {
        val hex = "04005AC33890"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        val total = helper.evaluate(packet)
        assertEquals(54, total)
    }

    @Test
    fun minTest() {
        val hex = "880086C3E88112"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        val total = helper.evaluate(packet)
        assertEquals(7, total)
    }

    @Test
    fun maxTest() {
        val hex = "CE00C43D881120"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        val total = helper.evaluate(packet)
        assertEquals(9, total)
    }

    @Test
    fun lesserTest() {
        val hex = "D8005AC2A8F0"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        val total = helper.evaluate(packet)
        assertEquals(1, total)
    }

    @Test
    fun greaterTest() {
        val hex = "F600BC2D8F"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        val total = helper.evaluate(packet)
        assertEquals(0, total)
    }

    @Test
    fun equalsTest() {
        val hex = "9C005AC2F8F0"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        val total = helper.evaluate(packet)
        assertEquals(0, total)
    }

    @Test
    fun multiOperationsTest() {
        val hex = "9C0141080250320F1802104A08"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        val total = helper.evaluate(packet)
        assertEquals(1, total)
    }

    @Test
    fun finalOperationsTest() {
        val hex = "A052E04CFD9DC0249694F0A11EA2044E200E9266766AB004A525F86FFCDF4B25DFC401A20043A11C61838600FC678D51B8C0198910EA1200010B3EEA40246C974EF003331006619C26844200D414859049402D9CDA64BDEF3C4E623331FBCCA3E4DFBBFC79E4004DE96FC3B1EC6DE4298D5A1C8F98E45266745B382040191D0034539682F4E5A0B527FEB018029277C88E0039937D8ACCC6256092004165D36586CC013A008625A2D7394A5B1DE16C0E3004A8035200043220C5B838200EC4B8E315A6CEE6F3C3B9FFB8100994200CC59837108401989D056280803F1EA3C41130047003530004323DC3C860200EC4182F1CA7E452C01744A0A4FF6BBAE6A533BFCD1967A26E20124BE1920A4A6A613315511007A4A32BE9AE6B5CAD19E56BA1430053803341007E24C168A6200D46384318A6AAC8401907003EF2F7D70265EFAE04CCAB3801727C9EC94802AF92F493A8012D9EABB48BA3805D1B65756559231917B93A4B4B46009C91F600481254AF67A845BA56610400414E3090055525E849BE8010397439746400BC255EE5362136F72B4A4A7B721004A510A7370CCB37C2BA0010D3038600BE802937A429BD20C90CCC564EC40144E80213E2B3E2F3D9D6DB0803F2B005A731DC6C524A16B5F1C1D98EE006339009AB401AB0803108A12C2A00043A134228AB2DBDA00801EC061B080180057A88016404DA201206A00638014E0049801EC0309800AC20025B20080C600710058A60070003080006A4F566244012C4B204A83CB234C2244120080E6562446669025CD4802DA9A45F004658527FFEC720906008C996700397319DD7710596674004BE6A161283B09C802B0D00463AC9563C2B969F0E080182972E982F9718200D2E637DB16600341292D6D8A7F496800FD490BCDC68B33976A872E008C5F9DFD566490A14"
        val helper = DecoderHelper()
        val binary = helper.hexToBinary(hex)
        val packet = helper.getPacket(binary)
        packet as OperatorPacket
        val total = helper.evaluate(packet)
        assertEquals(539051801941, total)
    }
}