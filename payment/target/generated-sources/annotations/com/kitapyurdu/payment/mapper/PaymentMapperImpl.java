package com.kitapyurdu.payment.mapper;

import com.kitapyurdu.payment.dto.PaymentDto;
import com.kitapyurdu.payment.entity.Transaction;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-12T11:19:36+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentDto toResource(Transaction e) {
        if ( e == null ) {
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();

        paymentDto.paymentId = e.getPaymentId();
        paymentDto.cardNumber = e.getCardNumber();
        paymentDto.cardCCV = e.getCardCCV();
        paymentDto.expirationDate = e.getExpirationDate();

        return paymentDto;
    }

    @Override
    public Transaction toEntity(PaymentDto r) {
        if ( r == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setPaymentId( r.paymentId );
        transaction.setCardNumber( r.cardNumber );
        transaction.setCardCCV( r.cardCCV );
        transaction.setExpirationDate( r.expirationDate );

        return transaction;
    }

    @Override
    public List<PaymentDto> toResource(List<Transaction> eList) {
        if ( eList == null ) {
            return null;
        }

        List<PaymentDto> list = new ArrayList<PaymentDto>( eList.size() );
        for ( Transaction transaction : eList ) {
            list.add( toResource( transaction ) );
        }

        return list;
    }

    @Override
    public List<Transaction> toEntity(List<PaymentDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Transaction> list = new ArrayList<Transaction>( rList.size() );
        for ( PaymentDto paymentDto : rList ) {
            list.add( toEntity( paymentDto ) );
        }

        return list;
    }
}
