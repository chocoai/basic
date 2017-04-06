package com.originsys.realtygis.domain;

import javax.transaction.xa.Xid;

/**
 auth:boy 2014-2-17
   描述：异步事务控制的xid
 */
public class MyXid implements Xid{
	 int formatId; 
     byte globalTransactionId[]; 
     byte branchQualifier[]; 
     public MyXid(){ 

     } 
     public MyXid(int formatId,byte[] globalTransactionId,byte[] branchQualifier){ 
         this.formatId = formatId; 
         this.globalTransactionId = globalTransactionId; 
         this.branchQualifier = branchQualifier; 
     } 

     public int getFormatId() { 
         return this.formatId; 
     } 
     public void setFormatId(int formatId){ 
         this.formatId = formatId; 
     } 
     public byte[] getGlobalTransactionId() { 
         return this.globalTransactionId; 
     } 
     public void setGlobalTransactionId(byte[] globalTransactionId){ 
         this.globalTransactionId = globalTransactionId; 
     } 
     public byte[] getBranchQualifier() { 
         return this.branchQualifier; 
     } 
     public void setBranchQualifier(byte[] branchQualifier){ 
         this.branchQualifier = branchQualifier; 
     } 
 
}
