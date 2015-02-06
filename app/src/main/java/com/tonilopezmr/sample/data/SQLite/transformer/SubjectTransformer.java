package com.tonilopezmr.sample.data.SQLite.transformer;

import android.content.ContentValues;
import android.database.Cursor;

import com.tonilopezmr.sample.SQLiteTransformer;
import com.tonilopezmr.sample.data.SQLite.entity.SubjectEntity;

/**
 * Created by toni on 05/02/15.
 */
public class SubjectTransformer implements SQLiteTransformer<SubjectEntity>{

    public static final String ID = "id";
    public static final String NAME = "name";

    public static final String TABLE_NAME = "subject";
    public static final String[] FIELDS = {ID, NAME};

    @Override
    public SubjectEntity transform(Cursor cursor) throws Exception {
        int id = cursor.getInt(0);
        String name = cursor.getString(1);
        return new SubjectEntity(id, name);
    }

    @Override
    public ContentValues transform(SubjectEntity dto) throws Exception {
        ContentValues values = new ContentValues();
        values.put(ID, dto.getId());
        values.put(NAME, dto.getName());

        return values;
    }

    @Override
    public String getWhereClause(SubjectEntity dto) throws Exception {
        return  ID+"="+dto.getId();
    }

    @Override
    public SubjectEntity setId(SubjectEntity dto, Object id) throws Exception {
        dto.setId((Integer.valueOf(dto.toString())));
        return dto;
    }

    @Override
    public String[] getFields() throws Exception {
        return FIELDS;
    }

    @Override
    public String getTableName() throws Exception {
        return TABLE_NAME;
    }
}