
public class ContactEntry {
	
		private final String _first;
		private final String _last;
		private final String _number;

			public ContactEntry (String number, String last, String first) {
				_first = first;
				_last = last;
				_number = number;
			}

			public String get_first() {
				return _first;
			}
			
			public String get_last() {
				return _last;
			}
			
			public String get_num() {
				return _number;
			}

}
