<!-- Modal -->
<form method="post" action="newMail">
	<div id="newMail" class="modal hide fade in" style="display: none;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>
				New mail
			</h3>
		</div>
		<div class="modal-body">
			<input type="hidden" value="${profile.email}" name="mailTo">
			<input type="text" placeholder="Title" name="mailTitle">
			<textarea rows="6" class="span6" placeholder="write new mail here..."
				name="mailMessage"></textarea>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary">Send</button>
		</div>	
	</div>
</form>