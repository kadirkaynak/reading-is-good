package com.company.readingisgood.service.impl;

import com.company.readingisgood.entity.DatabaseSequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SequenceGeneratorServiceTest {

    @InjectMocks
    private SequenceGeneratorService sequenceGeneratorService;

    @Mock
    private MongoOperations mongoOperations;

    @Test
    public void Given_Book_When_SaveBook_Then_ReturnBook() {
        //
        // Given
        //
        DatabaseSequence databaseSequence = new DatabaseSequence();
        databaseSequence.setSeq(1L);
        databaseSequence.setId("seqName");
        when(mongoOperations.findAndModify( any(Query.class), any(Update.class),any(FindAndModifyOptions.class), any(Class.class))).thenReturn(databaseSequence);
        //
        // When
        //
        Long aLong = sequenceGeneratorService.generateSequence("seqName");
        //
        // Then
        //
        Assertions.assertNotNull(aLong);
    }

}