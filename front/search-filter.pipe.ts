import { Pipe, PipeTransform } from '@angular/core';
import { Demande } from './Models/demande';

@Pipe({
  name: 'searchFilter'
})
export class SearchFilterPipe implements PipeTransform {

  transform(demandes: Demande[],searchValue:string): Demande[] {
   if (!demandes){
     return demandes;
   }
   return demandes.filter(demande =>
    demande.refbf)
    
  }

}
