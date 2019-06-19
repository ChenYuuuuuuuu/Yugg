package io.chenyu.bitcoinexplorer0612.controller;

import io.chenyu.bitcoinexplorer0612.dto.*;
import io.chenyu.bitcoinexplorer0612.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {
    @Autowired
    private BlockService blockService;
    @GetMapping("/getBlock")
    public  List<BlockListDTO> getRecentBlocks(){
        List<BlockListDTO> recentblocks = blockService.getRecentblocks();

        return  recentblocks;
    }
    @GetMapping("/getByBlockhash")
    public BlockGetDTO getByBlockhash(@RequestParam String blockhash){
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
        blockGetDTO.setHeight(580643);
        blockGetDTO.setPrevBlcok("00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44");
        blockGetDTO.setNextBlock("00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5");
        blockGetDTO.setMerkleRoot("07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798");
        blockGetDTO.setTime(new Date().getTime());
        blockGetDTO.setFees(8766.38);
        blockGetDTO.setTxSize((short) 2702);
        blockGetDTO.setSize(1322496);
        blockGetDTO.setDifficulty(7409399249090.25);
        blockGetDTO.setSize(20);
        blockGetDTO.setTotal_input(128.924);
        blockGetDTO.setTotal_output(128.923);
        blockGetDTO.setFees(1.02);
        blockGetDTO.setFee_per_byte(20.774);
        blockGetDTO.setFee_per_weight_unit(25.6);
        blockGetDTO.setEstimated(29.99);

        return blockGetDTO;
    }
    @GetMapping("/getByHeight")
    public BlockGetDTObyHeight getByHeight(@RequestParam Integer height){

        BlockGetDTObyHeight blockGetDTObyHeight = new BlockGetDTObyHeight();
        blockGetDTObyHeight.setHeight(580770);
        blockGetDTObyHeight.setNumber_of_transactions(2867);
        blockGetDTObyHeight.setOutput_total(128.929);
        blockGetDTObyHeight.setEmstimated_transaction_volume(9640.2);
        blockGetDTObyHeight.setTimestamp(new Date());
        blockGetDTObyHeight.setRECEIVED_time(new Date());
        blockGetDTObyHeight.setRelayed_by("pool");
        blockGetDTObyHeight.setDifficulty(9426.25);
        blockGetDTObyHeight.setBits(36599);
        blockGetDTObyHeight.setSize(25556.2);
        blockGetDTObyHeight.setWeight(3962.5);
        blockGetDTObyHeight.setVersion("0x265");
        blockGetDTObyHeight.setNonce(264598);
        blockGetDTObyHeight.setBlock_reward(108.69);

        return blockGetDTObyHeight;
    }
    @GetMapping("/getByTransactionHash")
    public TransactionBTO getTransaction(@RequestParam String  hash){
        TransactionBTO transactionBTO = new TransactionBTO();
        transactionBTO.setAddress("00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44");
        transactionBTO.setHass_160("00000ac7036789bfec28d230dff491f3382f6daf6523f5c44");
        transactionBTO.setNo_Transactions(1);
        transactionBTO.setTotal_received(10.26);
        transactionBTO.setFinal_balance(10.36549);
        return transactionBTO;
    }
   @GetMapping("/getByRelayed")
    public BlockbyRelayedDTO getByRelayed(@RequestParam String name){
       BlockbyRelayedDTO blockbyRelayedDTO = new BlockbyRelayedDTO();
       blockbyRelayedDTO.setHeight(580777);
       blockbyRelayedDTO.setTime(new Date());
       blockbyRelayedDTO.setHash("00000000000000000006af25ecaff6d2300fe8cbf5797bcef66c88b367978afe");
       blockbyRelayedDTO.setSize(1.2658);
       return blockbyRelayedDTO;
   }

}
